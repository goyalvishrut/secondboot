package com.example.secondboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecondbootApplication

fun main(args: Array<String>) {
	runApplication<SecondbootApplication>(*args)
}
