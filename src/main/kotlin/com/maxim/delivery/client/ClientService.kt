package com.maxim.delivery.client

import org.springframework.stereotype.Service

@Service
class ClientService(
    val clientRepository: ClientRepository,
    val clientMapper: ClientMapper
) {
    fun getAllClients(): List<ClientResponseDto> {
        val clients = clientRepository.findAll()
        return clients.map { clientMapper.toResponse(it) }
    }

    fun createClient(clientRequestDto: ClientRequestDto): ClientResponseDto {
        val clientEntity = clientMapper.toEntity(clientRequestDto)
        val savedClient = clientRepository.save(clientEntity)
        return clientMapper.toResponse(savedClient)
    }
}