package com.cristiadu.expenses.bot.config

import org.junit.Before
import org.junit.Test
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.util.AssertionErrors.assertTrue
import javax.validation.Validation


internal class ApplicationConfigTest() {
    private lateinit var applicationConfig: ApplicationConfig
    private val validator = Validation.buildDefaultValidatorFactory().validator

    @Before
    fun setupTests() {
        applicationConfig = buildDefaultTestingConfig()
    }

    @Test
    fun testPassAllValidations() {
        applicationConfig.privateKeyFilePath = "/folder"
        applicationConfig.supervisorId = "1111"
        val constraintViolations = validator.validate(applicationConfig)
        assertTrue("More validation errors than expected!", constraintViolations.isEmpty())
    }

    @Test
    fun testFailPrivateKeyValidation() {
        val expectedViolations = ArrayList<String>()
        expectedViolations.add("privateKeyFilePath must not be blank")

        applicationConfig.privateKeyFilePath = ""
        val constraintViolations = validator.validate(applicationConfig)
        val constraintViolationsString = constraintViolations
                .map { constraintViolation -> "${constraintViolation.propertyPath} ${constraintViolation.message}" }

        val foundAllViolations = expectedViolations
                .all { expectedViolation -> constraintViolationsString.contains(expectedViolation) }

        assertEquals("More validation errors than expected!", 1, constraintViolations.size)
        assertTrue("Didn't receive expected violation!", foundAllViolations)
    }

    @Test
    fun testFailUserIdValidation() {
        val expectedViolations = ArrayList<String>()
        expectedViolations.add("supervisorId must not be blank")

        applicationConfig.supervisorId = ""
        val constraintViolations = validator.validate(applicationConfig)
        val constraintViolationsString = constraintViolations
                .map { constraintViolation -> "${constraintViolation.propertyPath} ${constraintViolation.message}" }

        val foundAllViolations = expectedViolations
                .all { expectedViolation -> constraintViolationsString.contains(expectedViolation) }

        assertEquals("More validation errors than expected!", 1, constraintViolations.size)
        assertTrue("Didn't receive expected violation!", foundAllViolations)
    }

    @Test
    fun testFailAgentUrlValidation() {
        val expectedViolations = ArrayList<String>()
        expectedViolations.add("agentUrl must be a valid URL")

        applicationConfig.agentUrl = "somethingNotUrl"
        val constraintViolations = validator.validate(applicationConfig)
        val constraintViolationsString = constraintViolations
                .map { constraintViolation -> "${constraintViolation.propertyPath} ${constraintViolation.message}" }

        val foundAllViolations = expectedViolations
                .all { expectedViolation -> constraintViolationsString.contains(expectedViolation) }

        assertEquals("More validation errors than expected!", 1, constraintViolations.size)
        assertTrue("Didn't receive expected violation!", foundAllViolations)
    }

    @Test
    fun testFailPodUrlValidation() {
        val expectedViolations = ArrayList<String>()
        expectedViolations.add("podUrl must be a valid URL")

        applicationConfig.podUrl = "somethingNotUrl"
        val constraintViolations = validator.validate(applicationConfig)
        val constraintViolationsString = constraintViolations
                .map { constraintViolation -> "${constraintViolation.propertyPath} ${constraintViolation.message}" }

        val foundAllViolations = expectedViolations
                .all { expectedViolation -> constraintViolationsString.contains(expectedViolation) }

        assertEquals("More validation errors than expected!", 1, constraintViolations.size)
        assertTrue("Didn't receive expected violation!", foundAllViolations)
    }

    @Test
    fun testFailAllValidations() {
        val expectedViolations = ArrayList<String>()
        expectedViolations.add("supervisorId must not be blank")
        expectedViolations.add("privateKeyFilePath must not be blank")

        applicationConfig.supervisorId = ""
        applicationConfig.agentUrl = ""
        applicationConfig.podUrl = ""
        applicationConfig.privateKeyFilePath = ""
        val constraintViolations = validator.validate(applicationConfig)
        val constraintViolationsString = constraintViolations
                .map { constraintViolation -> "${constraintViolation.propertyPath} ${constraintViolation.message}" }

        val foundAllViolations = expectedViolations
                .all { expectedViolation -> constraintViolationsString.contains(expectedViolation) }

        assertEquals("More validation errors than expected!", 4, constraintViolations.size)
        assertTrue("Didn't receive expected violation!", foundAllViolations)
    }

    private fun buildDefaultTestingConfig(): ApplicationConfig {
        val applicationConfig = ApplicationConfig()
        applicationConfig.supervisorId = "1111"
        applicationConfig.agentUrl = "https://agent.localhost.com"
        applicationConfig.podUrl = "https://pod.localhost.com"
        applicationConfig.privateKeyFilePath = "/test"

        return applicationConfig
    }
}