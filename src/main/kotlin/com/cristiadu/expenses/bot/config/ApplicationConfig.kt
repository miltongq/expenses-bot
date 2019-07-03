package com.cristiadu.expenses.bot.config

import org.hibernate.validator.constraints.URL
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated
import java.io.File
import javax.validation.constraints.NotBlank

@Validated
@ConfigurationProperties("app.config")
@Configuration
class ApplicationConfig() {
    @field:NotBlank
    @field:Value("\${privateKey:#{null}}")
    lateinit var privateKeyFilePath: String

    @field:NotBlank
    @field:Value("\${supervisorId:#{null}}")
    lateinit var supervisorId: String

    @field:NotBlank
    @field:URL
    @field:Value("\${agentUrl:#{null}}")
    lateinit var agentUrl: String

    @field:NotBlank
    @field:URL
    @field:Value("\${podUrl:#{null}}")
    lateinit var podUrl: String

    fun getPrivateKeyAsFile() = File(privateKeyFilePath)
}