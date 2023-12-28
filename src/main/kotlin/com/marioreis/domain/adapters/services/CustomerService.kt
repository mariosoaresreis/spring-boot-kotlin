package com.marioreis.domain.adapters.services

import com.marioreis.domain.dto.CustomerDTO
import com.marioreis.domain.dto.InsertCostumerRequestDTO
import com.marioreis.domain.dto.InsertCustomerResponseDTO
import com.marioreis.domain.dto.InsertCustomerResponseDetailDTO
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import com.marioreis.domain.ports.repositories.CustomerRepositoryPort
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepositoryPort?): CustomerServicePort {
    override fun insertCustomers(insertCustomers: InsertCostumerRequestDTO): InsertCustomerResponseDTO {

        val customersList = ArrayList<CustomerDTO>()
        val customersListResponse = ArrayList<InsertCustomerResponseDetailDTO>()

        insertCustomers.customers.forEach {
            val fields = it.split(";")
            val id: Long =  fields[0].toLong()
            val name: String = fields[1]
            customersList.add(CustomerDTO(id, name))
        }

        customerRepository?.saveAll(customersList)
        val response = InsertCustomerResponseDTO(insertCustomers.fileName, customersListResponse)
        return response
    }
}