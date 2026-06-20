package com.maxim.delivery.deliveryManagement

import com.maxim.delivery.DeliveryAssignEvent
import com.maxim.delivery.courier.CourierService
import com.maxim.delivery.order.OrderMapper
import com.maxim.delivery.order.OrderRequestDto
import com.maxim.delivery.order.OrderResponseDto
import com.maxim.delivery.order.OrderService
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    val eventPublisher: ApplicationEventPublisher,
    val courierService: CourierService,
    val orderMapper: OrderMapper,
    val orderService: OrderService
) {
    private val logger = LoggerFactory.getLogger(DeliveryService::class.java)

    fun createAndPublishOrder(orderRequestDto: OrderRequestDto): OrderResponseDto {
        val order = orderService.createAndReturnEntity(orderRequestDto)
        val courierToDeliver = courierService.findLeastBusyCourier()
        val orderWithAssignedCourier = orderService.assignCourierAndSaveOrder(order, courierToDeliver)

        logger.info("Publishing DeliveryAssignEvent for order id={}", orderWithAssignedCourier.id)
        eventPublisher.publishEvent(DeliveryAssignEvent(orderWithAssignedCourier))

        return orderMapper.toResponse(orderWithAssignedCourier)
    }
}