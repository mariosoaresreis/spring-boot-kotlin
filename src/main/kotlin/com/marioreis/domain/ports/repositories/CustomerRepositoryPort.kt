package com.marioreis.domain.ports.repositories

import com.marioreis.domain.dto.CustomerDTO

interface CustomerRepositoryPort {
    fun findById(id: Long): CustomerDTO
    fun saveAll(customers: List<CustomerDTO>)
    fun save(customer: CustomerDTO):CustomerDTO
    fun delete(customer: CustomerDTO)
    fun deleteAll()
    fun getCustomersCount():Int?
}