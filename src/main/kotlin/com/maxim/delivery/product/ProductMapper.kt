package com.maxim.delivery.product

import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun toEntity(productRequestDTO: ProductRequestDTO): Product {
        return Product(
            name = productRequestDTO.name,
            price = productRequestDTO.price
        )
    }

    fun toResponse(product: Product): ProductResponseDTO {
        return ProductResponseDTO(
            id = product.id!!,
            name = product.name,
            createdAt = product.createdAt!!,
            price = product.price
        )
    }
}