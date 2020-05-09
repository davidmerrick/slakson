package io.github.davidmerrick.slakson.config

import io.micronaut.context.annotation.ConfigurationProperties
import javax.inject.Singleton
import javax.validation.constraints.NotBlank

@Singleton
@ConfigurationProperties("slack")
class SlackConfig {
    @get:NotBlank
    lateinit var token: String
}