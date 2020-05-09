package io.github.davidmerrick.slakson.messages

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
data class EventCallbackMessage(
        @JsonProperty("token")
        val token: String,
        @JsonProperty("team_id")
        val teamId: String,
        @JsonProperty("api_app_id")
        val apiAppId: String,
        @JsonProperty("event")
        val event: SlackEvent
) : SlackMessage {
    override val type = MessageType.EVENT_CALLBACK

    @JsonIgnore
    fun isBotMessage() = event.subtype == "bot_message" || event.botId != null
}