package ru.zgys.tpchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TpChat

fun main(args: Array<String>) {
	runApplication<TpChat>(*args)
}
