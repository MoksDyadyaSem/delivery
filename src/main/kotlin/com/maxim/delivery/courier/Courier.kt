package com.maxim.delivery.courier

import com.maxim.delivery.BaseEntity
import com.maxim.delivery.order.Order
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "couriers")
class Courier(
    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "deliveredBy")
    val ordersToDeliver: MutableList<Order>
) : BaseEntity()