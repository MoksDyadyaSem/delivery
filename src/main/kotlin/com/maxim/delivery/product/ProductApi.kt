package com.maxim.delivery.product

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Товары", description = "Управление товарами")
interface ProductApi {

    @Operation(
        summary = "Получить все товары",
        description = "Возвращает список всех доступных товаров с ценами"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Список товаров успешно получен",
        content = [Content(array = ArraySchema(schema = Schema(implementation = ProductResponseDTO::class)))]
    )
    fun getAllProducts(): ResponseEntity<List<ProductResponseDTO>>

    @Operation(
        summary = "Создать товар",
        description = "Добавляет новый товар в каталог"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Товар успешно создан",
        content = [Content(schema = Schema(implementation = ProductResponseDTO::class))]
    )
    fun createProduct(@RequestBody productRequestDTO: ProductRequestDTO): ResponseEntity<ProductResponseDTO>
}
