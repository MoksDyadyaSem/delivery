package com.maxim.delivery.product

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    val productService: ProductService
) {
    @GetMapping
    fun getAllProducts(): ResponseEntity<List<ProductResponseDTO>> {
        val products = productService.getAllProducts()
        return ResponseEntity.ok(products)
    }

    @PostMapping
    fun createProduct(@RequestBody productRequestDTO: ProductRequestDTO): ResponseEntity<ProductResponseDTO> {
        val productToSave = productService.createProduct(productRequestDTO)
        return ResponseEntity.ok(productToSave)
    }
}