package com.maxim.delivery.order

import com.maxim.delivery.client.Client
import com.maxim.delivery.client.ClientRepository
import com.maxim.delivery.courier.CourierMapper
import com.maxim.delivery.product.Product
import com.maxim.delivery.product.ProductMapper
import com.maxim.delivery.product.ProductRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderMapper(
    val clientRepository: ClientRepository,
    val productRepository: ProductRepository,
    val courierMapper: CourierMapper,
    val productMapper: ProductMapper
) {
    fun toEntity(orderRequestEntity: OrderRequestDto): Order {
        return Order(
            orderedBy = findClientById(orderRequestEntity.clientId),
            deliveredBy = null,
            productList = findProductsByIds(orderRequestEntity.productIds),
            status = OrderStatus.CREATED
        )
    }

    fun toResponse(order: Order): OrderResponseDto {
        return OrderResponseDto(
            id = order.id!!,
            // если курьер не null, то верни его id
            deliveredBy = order.deliveredBy?.let { courierMapper.toResponse(it) },
            createdAt = order.createdAt!!,
            productList = order.productList.map { productMapper.toResponse(it) }
        )
    }

    private fun findClientById(clientId: UUID): Client {
        return clientRepository.findById(clientId)
            .orElseThrow {
                RuntimeException("client with id $clientId was not found!")
            }
    }

    private fun findProductsByIds(productsIds: List<UUID>): List<Product> {
        return productRepository.findAllById(productsIds)
    }
}