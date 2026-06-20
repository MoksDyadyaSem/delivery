package com.maxim.delivery.order

import com.maxim.delivery.courier.Courier
import org.springframework.stereotype.Service

@Service
class OrderService(
    val orderRepository: OrderRepository,
    val orderMapper: OrderMapper,
) {
    fun getAllOrders(): List<OrderResponseDto> {
        val orders = orderRepository.findAll()
        return orders.map { orderMapper.toResponse(it) }
    }

    fun assignCourier(order: Order, courier: Courier): Order {
        order.deliveredBy = courier
        return orderRepository.save(order)
    }

    fun createAndReturnEntity(orderRequestDto: OrderRequestDto): Order {
        val orderEntity = orderMapper.toEntity(orderRequestDto)
        return orderRepository.save(orderEntity)
    }
}