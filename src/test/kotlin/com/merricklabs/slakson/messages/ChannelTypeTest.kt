package com.merricklabs.slakson.messages

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class ChannelTypeTest {

    private val mapper = ObjectMapper().registerKotlinModule()

    data class MyClass(val type: ChannelType)

    @Test
    fun `Should properly deserialize lowercased property`() {
        val payload = mapper.writeValueAsString(mapOf("type" to "channel"))
        val myClass = mapper.readValue<MyClass>(payload)
        myClass.type shouldBe ChannelType.CHANNEL
    }
}