package com.merricklabs.slakson.client

import com.merricklabs.slakson.messages.CreateMessagePayload

interface SlackClient {
    fun postMessage(payload: CreateMessagePayload)
}