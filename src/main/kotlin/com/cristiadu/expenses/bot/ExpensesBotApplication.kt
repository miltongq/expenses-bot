package com.cristiadu.expenses.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExpensesBotApplication

fun main(args: Array<String>) {
	runApplication<ExpensesBotApplication>(*args)
}
