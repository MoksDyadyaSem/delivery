package com.maxim.delivery.product

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productMapper: ProductMapper
) {
    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun getAllProducts(): List<ProductResponseDTO> {
        val products = productRepository.findAll()
        logger.debug("Fetched {} products", products.size)
        return products.map { productMapper.toResponse(it) }
    }

    fun createProduct(productRequestDTO: ProductRequestDTO): ProductResponseDTO {
        val productEntity = productMapper.toEntity(productRequestDTO)
        val savedProduct = productRepository.save(productEntity)
        logger.info("Product created: id={}, name={}", savedProduct.id, savedProduct.name)
        return productMapper.toResponse(savedProduct)
    }
}