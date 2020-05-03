package com.merricklabs.slakson.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.micronaut.core.annotation.Introspected

@JsonIgnoreProperties(ignoreUnknown = true)
@Introspected
data class SlackResponseImpl(
        override val ok: Boolean,
        override val error: String?
) : SlackResponse