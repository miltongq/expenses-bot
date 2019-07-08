package com.cristiadu.expenses.bot.message.client

import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class MessageClientTest {

    @Test
    internal fun testCallHealthCheck() {
        val messageClient = MessageClient()

        runBlocking {
            val componentMap = messageClient.callAgentCreateMessage()
            componentMap.forEach {
                (k, v) -> println("$k, $v")
            }
        }
    }
}