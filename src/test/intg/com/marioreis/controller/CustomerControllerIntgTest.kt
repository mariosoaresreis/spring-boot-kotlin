package com.marioreis.controller

import com.marioreis.domain.dto.CustomerDTO
import com.marioreis.infrastructure.adapters.repositories.CustomerRepository
import com.marioreis.mocks.CustomerMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CustomerControllerIntgTest {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var webTestClient: WebTestClient
    @BeforeEach
    fun setUp() {
        customerRepository.deleteAll()
        val customer = CustomerMock.getCustomerMock()
        customerRepository.save(customer)
    }

    @Test
    fun addCustomer() {
        val customer = customerRepository.findById( CustomerMock.CUSTOMER_ID)

        val savedCustomerDTO = webTestClient
            .post()
            .uri("/v1/customers")
            .bodyValue(customer)
            .exchange()
            .expectStatus().isOk
            .expectBody(CustomerDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            savedCustomerDTO!!.id != null
        }
    }
}