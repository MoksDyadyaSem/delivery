package com.maxim.delivery.order

import com.maxim.delivery.courier.Courier
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OrderService(
    val orderRepository: OrderRepository,
    val orderMapper: OrderMapper,
) {
    private val logger = LoggerFactory.getLogger(OrderService::class.java)

    fun getAllOrders(): List<OrderResponseDto> {
        val orders = orderRepository.findAll()
        logger.debug("Fetched {} orders", orders.size)
        return orders.map { orderMapper.toResponse(it) }
    }

    fun createAndReturnEntity(orderRequestDto: OrderRequestDto): Order {
        val orderEntity = orderMapper.toEntity(orderRequestDto)
        val saved = orderRepository.save(orderEntity)
        logger.info("Order created with id={}", saved.id)
        return saved
    }

    fun assignCourierAndSaveOrder(order: Order, courier: Courier): Order {
        order.courier = courier
        logger.info("Courier id={} assigned to order id={}", courier.id, order.id)
        return updateOrderStatusAndSave(order, OrderStatus.ASSIGNED)
    }

    fun updateOrderStatusAndSave(order: Order, status: OrderStatus): Order {
        order.status = status
        logger.info("Order id={} status changed to {}", order.id, status)
        return orderRepository.save(order)
    }
}