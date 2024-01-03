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

    override fun save(customer: CustomerDTO):CustomerDTO {
        val customerEntity = customerRepositorySpringBoot.save(CustomerEntity( customer.id, customer.name))
        val result = CustomerDTO(customerEntity.id, customerEntity.name)
        return result
    }

    override fun delete(customer: CustomerDTO) {
        customerRepositorySpringBoot.delete()
    }

    override fun getCustomersCount(): Int? {
        val list = customerRepositorySpringBoot.findAll()
        return list.size
    }
}