package com.maxim.delivery.order

import com.maxim.delivery.BaseEntity
import com.maxim.delivery.client.Client
import com.maxim.delivery.courier.Courier
import com.maxim.delivery.product.Product
import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @ManyToOne // много заказов могут быть у одного клиента
    @JoinColumn(name = "client_id") // задаём имя для foreign key
    val orderedBy: Client,

    @ManyToOne // много заказов могут быть у одного курьера
    @JoinColumn(name = "courier_id")
    var courier: Courier?,

    @Column(nullable = false, updatable = true)
    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.CREATED,

    @ManyToMany // много заказов может содержать много продуктов
    @JoinTable(
        name = "order_products", // имя промежуточной таблицы
        joinColumns = [JoinColumn(name = "order_id")], // наш id
        inverseJoinColumns = [JoinColumn(name = "product_id")] // чужой id
    )
    val productList: List<Product>,
) : BaseEntity()