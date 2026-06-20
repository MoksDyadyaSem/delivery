package com.maxim.delivery

import com.maxim.delivery.courier.CourierService
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class CourierEventListener(
    val courierService: CourierService
) {
    private val logger = LoggerFactory.getLogger(CourierEventListener::class.java)

    @Async
    @EventListener
    fun onDeliveryAssign(event: DeliveryAssignEvent) {
        val order = event.order
        val courier = order.courier
        logger.info("DeliveryAssignEvent received: order id={}, courier id={}", order.id, courier?.id)
        courierService.deliver(courier!!.id!!)
    }
}