package com.productmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductmanagerApplication

fun main(args: Array<String>) {
	runApplication<ProductmanagerApplication>(*args)
}
