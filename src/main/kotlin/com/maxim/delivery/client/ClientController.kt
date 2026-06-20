package com.maxim.delivery.client

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/clients")
class ClientController(
    val clientService: ClientService
) {
    @GetMapping
    fun getAllClients(): ResponseEntity<List<ClientResponseDto>> {
        val clients = clientService.getAllClients()
        return ResponseEntity.ok(clients)
    }

    @PostMapping
    fun createClient(@RequestBody clientRequestDto: ClientRequestDto): ResponseEntity<ClientResponseDto> {
        val clientToCreate = clientService.createClient(clientRequestDto)
        return ResponseEntity.ok(clientToCreate)
    }
}