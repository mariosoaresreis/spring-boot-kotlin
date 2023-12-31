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
    fun saveCustomer() {
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

    @Test
    fun customersCount() {
        val result = webTestClient
            .get()
            .uri("/v1/customers/count")
            .exchange()
            .expectStatus().isOk
            .expectBody(Long::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            result == 1L
        }
    }

    @Test
    fun findById() {
        val result = webTestClient
            .get()
            .uri("/v1/customers/${CustomerMock.CUSTOMER_ID}")
            .exchange()
            .expectStatus().isOk
            .expectBody(CustomerDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            result!!.id != null
        }
    }

    @Test
    fun deleteCustomer() {
        webTestClient
            .delete()
            .uri("/v1/customers/${CustomerMock.CUSTOMER_ID}")
            .exchange()
            .expectStatus().isNoContent
            .expectBody(CustomerDTO::class.java)
            .returnResult()
            .responseBody

        val result = webTestClient
            .get()
            .uri("/v1/customers/count")
            .exchange()
            .expectStatus().isOk
            .expectBody(Long::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            result == 0L
        }
    }
}