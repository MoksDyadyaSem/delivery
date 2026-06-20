package com.maxim.delivery.order

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Заказы", description = "Создание заказов и просмотр их статусов")
interface OrderApi {

    @Operation(
        summary = "Получить все заказы",
        description = "Возвращает список всех заказов с текущими статусами и назначенными курьерами"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Список заказов успешно получен",
        content = [Content(array = ArraySchema(schema = Schema(implementation = OrderResponseDto::class)))]
    )
    fun getAllOrders(): ResponseEntity<List<OrderResponseDto>>

    @Operation(
        summary = "Создать заказ",
        description = "Создаёт новый заказ, автоматически назначает наименее занятого курьера и запускает доставку в фоне"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Заказ создан, курьер назначен",
        content = [Content(schema = Schema(implementation = OrderResponseDto::class))]
    )
    fun createOrder(@RequestBody orderRequestDto: OrderRequestDto): ResponseEntity<OrderResponseDto>
}
