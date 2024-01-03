package com.marioreis.domain.ports.interfaces

import com.marioreis.domain.dto.BulkInsertCostumerRequestDTO
import com.marioreis.domain.dto.BulkInsertCustomerResponseDTO
import com.marioreis.domain.dto.CustomerDTO

interface CustomerServicePort {
    fun bulkInsertCustomers(customers: BulkInsertCostumerRequestDTO): BulkInsertCustomerResponseDTO
    fun findById(id: Long): CustomerDTO
    fun save(customer: CustomerDTO): CustomerDTO
    fun delete(customer: CustomerDTO)
    fun getCustomersCount(): Int?
}