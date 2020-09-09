package ru.zgys.demo

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableRabbit
class History

fun main(args: Array<String>) {
	runApplication<History>(*args)
}
