package com.merricklabs.slakson.client

import com.merricklabs.slakson.SlackPaths.BASE_API_PATH
import com.merricklabs.slakson.SlackPaths.POST_MESSAGE_ENDPOINT
import com.merricklabs.slakson.config.SlackConfig
import com.merricklabs.slakson.messages.CreateMessagePayload
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import mu.KotlinLogging
import javax.inject.Singleton

private val log = KotlinLogging.logger {}

@Singleton
class SlackClientImpl(
        private val slackConfig: SlackConfig,
        @Client(BASE_API_PATH) private val client: HttpClient
) : SlackClient {
    override fun postMessage(payload: CreateMessagePayload) {
        val request = HttpRequest.POST(
                POST_MESSAGE_ENDPOINT,
                payload
        )
        request.headers.add("Authorization", "Bearer ${slackConfig.token}")
        val response = client.toBlocking().retrieve(request, HttpStatus::class.java)
        if (response != HttpStatus.OK) {
            log.error("Received bad status from Slack: $response")
        } else {
            log.info("Success: Posted response to Slack")
        }
    }
}