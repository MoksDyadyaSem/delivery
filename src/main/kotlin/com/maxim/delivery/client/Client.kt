package com.maxim.delivery.client

import com.maxim.delivery.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "clients")
class Client(
    @Column(nullable = false)
    val name: String
) : BaseEntity()