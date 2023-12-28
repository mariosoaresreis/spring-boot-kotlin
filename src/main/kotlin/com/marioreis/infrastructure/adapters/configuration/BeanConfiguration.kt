package com.marioreis.infrastructure.adapters.configuration

import com.marioreis.domain.adapters.services.CustomerService
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import com.marioreis.domain.ports.repositories.CustomerRepositoryPort
import com.marioreis.infrastructure.adapters.repositories.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun customerService(customerRepositoryPort: CustomerRepositoryPort?): CustomerServicePort {
        return CustomerService(customerRepositoryPort)
    }
}