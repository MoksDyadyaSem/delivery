package com.maxim.delivery.deliveryManagement

import com.maxim.delivery.courier.Courier
import com.maxim.delivery.courier.CourierService
import com.maxim.delivery.order.Order
import com.maxim.delivery.order.OrderMapper
import com.maxim.delivery.order.OrderRequestDto
import com.maxim.delivery.order.OrderResponseDto
import com.maxim.delivery.order.OrderService
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    val courierService: CourierService,
    val orderMapper: OrderMapper,
    val orderService: OrderService
) {

    fun createOrder(orderRequestDto: OrderRequestDto): OrderResponseDto {
        val order = orderService.createAndReturnEntity(orderRequestDto)
        val courierToDeliver = courierService.findLeastBusyCourier()
        val orderWithAssignedCourier = orderService.assignCourier(order, courierToDeliver)
        return orderMapper.toResponse(orderWithAssignedCourier)
    }
}