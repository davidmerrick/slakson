package com.merricklabs.slakson.messages

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.merricklabs.slakson.messages.EVENT_CALLBACK_STRING
import com.merricklabs.slakson.messages.EventCallbackMessage
import com.merricklabs.slakson.messages.MessageType
import com.merricklabs.slakson.messages.SlackChallenge
import com.merricklabs.slakson.messages.URL_VERIFICATION_STRING
import io.micronaut.core.annotation.Introspected

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes(
        JsonSubTypes.Type(value = SlackChallenge::class, name = URL_VERIFICATION_STRING),
        JsonSubTypes.Type(value = EventCallbackMessage::class, name = EVENT_CALLBACK_STRING)
)
@Introspected
interface SlackMessage {
    val type: MessageType
}