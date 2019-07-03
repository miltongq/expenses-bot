package com.cristiadu.expenses.bot

import com.cristiadu.expenses.bot.config.ApplicationConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig::class)
class ExpensesBotApplication

fun main(args: Array<String>) {
	runApplication<ExpensesBotApplication>(*args)
}
