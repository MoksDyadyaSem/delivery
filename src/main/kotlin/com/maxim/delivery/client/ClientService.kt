package com.maxim.delivery.client

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ClientService(
    val clientRepository: ClientRepository,
    val clientMapper: ClientMapper
) {
    private val logger = LoggerFactory.getLogger(ClientService::class.java)

    fun getAllClients(): List<ClientResponseDto> {
        val clients = clientRepository.findAll()
        logger.debug("Fetched {} clients", clients.size)
        return clients.map { clientMapper.toResponse(it) }
    }

    fun createClient(clientRequestDto: ClientRequestDto): ClientResponseDto {
        val clientEntity = clientMapper.toEntity(clientRequestDto)
        val savedClient = clientRepository.save(clientEntity)
        logger.info("Client created: id={}, name={}", savedClient.id, savedClient.name)
        return clientMapper.toResponse(savedClient)
    }
}