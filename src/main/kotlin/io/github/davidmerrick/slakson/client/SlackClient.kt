package io.github.davidmerrick.slakson.client

import io.github.davidmerrick.slakson.messages.CreateMessagePayload

interface SlackClient {
    fun postMessage(payload: CreateMessagePayload)
}