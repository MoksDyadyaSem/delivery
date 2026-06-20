package com.maxim.delivery

import com.maxim.delivery.client.*
import com.maxim.delivery.courier.CourierRequestDto
import com.maxim.delivery.courier.CourierService
import com.maxim.delivery.deliveryManagement.DeliveryService
import com.maxim.delivery.order.OrderRequestDto
import com.maxim.delivery.product.ProductRequestDTO
import com.maxim.delivery.product.ProductService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ApplicationBootstrap(
    val clientService: ClientService,
    val courierService: CourierService,
    val productService: ProductService,
    val deliveryService: DeliveryService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val client = clientService.createClient(ClientRequestDto("Максим"))

        courierService.createCourier(CourierRequestDto("Александр"))
        courierService.createCourier(CourierRequestDto("Олег"))
        courierService.createCourier(CourierRequestDto("Паша"))

        val pizza = productService.createProduct(ProductRequestDTO("Пицца", BigDecimal("500")))
        val cola = productService.createProduct(ProductRequestDTO("Кола", BigDecimal("100")))
        val chips = productService.createProduct(ProductRequestDTO("Чипсы", BigDecimal("140")))

        repeat(10) {
            deliveryService.createAndPublishOrder(
                OrderRequestDto(
                    clientId = client.id,
                    productIds = listOf(pizza.id, cola.id, chips.id)
                )
            )
        }
    }
}