package com.cristiadu.expenses.bot.message.client

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import java.util.ArrayList

class MessageClient {

    private val client = HttpClient(OkHttp) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    data class V4Message(
            internal var messageId: String? = null,
            internal var timestamp: Long? = null,
            internal var message: String? = null,
            internal var sharedMessage: V4Message? = null,
            internal var data: String? = null,
            internal var attachments: List<V4AttachmentInfo> = ArrayList(),
            internal var user: V4User? = null,
            internal var stream: V4Stream? = null,
            internal var externalRecipients: Boolean? = null,
            internal var diagnostic: String? = null,
            internal var userAgent: String? = null,
            internal var originalFormat: String? = null,
            internal var disclaimer: String? = null
    )

    data class V4Stream(
            internal var streamId: String? = null,
            internal var streamType: String? = null,
            internal var roomName: String? = null,
            internal var members: List<V4User> = ArrayList(),
            internal var external: Boolean? = null,
            internal var crossPod: Boolean? = null
    )

    data class V4AttachmentInfo(
            internal var id: String? = null,
            internal var name: String? = null,
            internal var size: Long? = null,
            internal var images: List<V4ThumbnailInfo> = ArrayList()
    )

    data class V4ThumbnailInfo(
            internal var id: String? = null,
            internal var dimension: String? = null
    )

    data class V4User(
            internal var userId: Long? = null,
            internal var firstName: String? = null,
            internal var lastName: String? = null,
            internal var displayName: String? = null,
            internal var email: String? = null,
            internal var username: String? = null
    )

    suspend fun callAgentCreateMessage(): V4Message {
        return client.post(
                urlString = "https://nx1.symphony.com/webcontroller/HealthCheck/aggregated"
        )
    }


}
