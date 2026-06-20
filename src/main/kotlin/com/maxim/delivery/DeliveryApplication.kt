package com.maxim.delivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class DeliveryApplication

fun main(args: Array<String>) {
	runApplication<DeliveryApplication>(*args)
}
