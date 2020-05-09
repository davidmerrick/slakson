package io.github.davidmerrick.slakson.messages

import io.micronaut.core.annotation.Introspected

@Introspected
data class SlackChallenge(
        val token: String,
        val challenge: String
) : SlackMessage {
    override val type: MessageType = MessageType.URL_VERIFICATION
}
