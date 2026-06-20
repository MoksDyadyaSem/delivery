package com.maxim.delivery

import com.maxim.delivery.order.Order

data class DeliveryAssignEvent(
    val order: Order
)