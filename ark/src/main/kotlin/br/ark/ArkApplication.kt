package br.ark

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArkApplication

fun main(args: Array<String>) {
	runApplication<ArkApplication>(*args)
}
