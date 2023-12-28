package com.marioreis.infrastructure.adapters.repositories

import com.marioreis.domain.dto.CustomerDTO
import com.marioreis.domain.ports.repositories.CustomerRepositoryPort
import com.marioreis.infrastructure.adapters.entities.CustomerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerRepository(private val customerRepositorySpringBoot: CustomerRepositorySpringBoot): CustomerRepositoryPort {

    override fun saveAll(customers: List<CustomerDTO>) {
        val customersList = ArrayList<CustomerEntity>()

        customers.forEach {
            customersList.add(CustomerEntity(it.id, it.name) )
        }

        customerRepositorySpringBoot.saveAll(customersList)
    }
}