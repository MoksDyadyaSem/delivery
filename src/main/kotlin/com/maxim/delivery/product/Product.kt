package com.maxim.delivery.product

import com.maxim.delivery.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "products")
class Product(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: BigDecimal
) : BaseEntity()