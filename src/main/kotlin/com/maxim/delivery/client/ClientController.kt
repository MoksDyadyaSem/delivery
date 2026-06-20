package com.maxim.delivery.client

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/clients")
class ClientController(
    val clientService: ClientService
) : ClientApi {

    override fun getAllClients(): ResponseEntity<List<ClientResponseDto>> {
        val clients = clientService.getAllClients()
        return ResponseEntity.ok(clients)
    }

    override fun createClient(@RequestBody clientRequestDto: ClientRequestDto): ResponseEntity<ClientResponseDto> {
        val clientToCreate = clientService.createClient(clientRequestDto)
        return ResponseEntity.ok(clientToCreate)
    }
}
