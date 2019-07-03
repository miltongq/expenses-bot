package com.cristiadu.expenses.bot

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations = ["/application-test.properties"])
internal class ExpensesBotApplicationTests {

	@Test
	fun contextLoads() {
		// Testing that application loads successfully
	}

}
