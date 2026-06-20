package com.maxim.delivery.courier

import com.maxim.delivery.order.OrderService
import com.maxim.delivery.order.OrderStatus
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourierService(
    val courierRepository: CourierRepository,
    val courierMapper: CourierMapper,
    val orderService: OrderService
) {
    private val logger = LoggerFactory.getLogger(CourierService::class.java)

    fun getAllCouriers(): List<CourierResponseDto> {
        val couriers = courierRepository.findAll()
        logger.debug("Fetched {} couriers", couriers.size)
        return couriers.map { courierMapper.toResponse(it) }
    }

    fun getCourierByID(courierId: UUID): Courier {
        return courierRepository.findById(courierId)
            .orElseThrow {
                logger.warn("Courier not found: id={}", courierId)
                RuntimeException("Курьер с id $courierId не был найден")
            }
    }

    fun createCourier(courierRequestDto: CourierRequestDto): CourierResponseDto {
        val courierEntity = courierMapper.toEntity(courierRequestDto)
        val savedCourier = courierRepository.save(courierEntity)
        logger.info("Courier created: id={}, name={}", savedCourier.id, savedCourier.name)
        return courierMapper.toResponse(savedCourier)
    }

    fun findLeastBusyCourier(): Courier {
        val courier = courierRepository.findLeastBusyCourier()
            .orElseThrow {
                logger.error("No available couriers found")
                RuntimeException("Courier was not found!")
            }
        logger.debug("Least busy courier: id={}, name={}", courier.id, courier.name)
        return courier
    }

    @Transactional
    fun deliver(courierId: UUID) {
        var courier = getCourierByID(courierId)
        logger.info("Courier id={} ({}) started delivery loop", courier.id, courier.name)
        while (courier.ordersToDeliver.isNotEmpty()) {
            val order = courier.ordersToDeliver.first()
            orderService.updateOrderStatusAndSave(order, OrderStatus.IN_PROGRESS)
            logger.info("Courier {} is delivering order id={}", courier.name, order.id)
            Thread.sleep(2000)
            orderService.updateOrderStatusAndSave(order, OrderStatus.DELIVERED)
            courier = getCourierByID(courierId)
        }
        logger.info("Courier id={} finished all deliveries", courierId)
    }
}