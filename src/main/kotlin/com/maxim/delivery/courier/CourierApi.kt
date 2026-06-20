package com.maxim.delivery.courier

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Курьеры", description = "Управление курьерами")
interface CourierApi {

    @Operation(
        summary = "Получить всех курьеров",
        description = "Возвращает список всех зарегистрированных курьеров"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Список курьеров успешно получен",
        content = [Content(array = ArraySchema(schema = Schema(implementation = CourierResponseDto::class)))]
    )
    fun getAllCouriers(): ResponseEntity<List<CourierResponseDto>>

    @Operation(
        summary = "Создать курьера",
        description = "Регистрирует нового курьера в системе"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Курьер успешно создан",
        content = [Content(schema = Schema(implementation = CourierResponseDto::class))]
    )
    fun createCourier(@RequestBody courierRequestDto: CourierRequestDto): ResponseEntity<CourierResponseDto>
}
