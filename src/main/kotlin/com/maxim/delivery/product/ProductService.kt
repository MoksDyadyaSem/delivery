package com.maxim.delivery.product

import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productMapper: ProductMapper
) {
    fun getAllProducts(): List<ProductResponseDTO> {
        val products = productRepository.findAll()
        return products.map { productMapper.toResponse(it) }
    }

    fun createProduct(productRequestDTO: ProductRequestDTO): ProductResponseDTO {
        val productEntity = productMapper.toEntity(productRequestDTO)
        val savedProduct = productRepository.save(productEntity)
        return productMapper.toResponse(savedProduct)
    }
}