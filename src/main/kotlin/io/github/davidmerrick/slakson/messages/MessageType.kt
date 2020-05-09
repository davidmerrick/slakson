package io.github.davidmerrick.slakson.messages

import com.fasterxml.jackson.annotation.JsonProperty

const val URL_VERIFICATION_STRING = "url_verification"
const val EVENT_CALLBACK_STRING = "event_callback"
const val MESSAGE_STRING = "message"

enum class MessageType {
    @JsonProperty(URL_VERIFICATION_STRING)
    URL_VERIFICATION,
    @JsonProperty(EVENT_CALLBACK_STRING)
    EVENT_CALLBACK,
    @JsonProperty(MESSAGE_STRING)
    MESSAGE
}
