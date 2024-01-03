package com.marioreis.domain.adapters.services

import com.marioreis.domain.dto.CustomerDTO
import com.marioreis.domain.dto.BulkInsertCostumerRequestDTO
import com.marioreis.domain.dto.BulkInsertCustomerResponseDTO
import com.marioreis.domain.dto.BulkInsertCustomerResponseDetailDTO
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import com.marioreis.domain.ports.repositories.CustomerRepositoryPort
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepositoryPort?): CustomerServicePort {
    override fun bulkInsertCustomers(insertCustomers: BulkInsertCostumerRequestDTO): BulkInsertCustomerResponseDTO {

        val customersList = ArrayList<CustomerDTO>()
        val customersListResponse = ArrayList<BulkInsertCustomerResponseDetailDTO>()

        insertCustomers.customers.forEach {
            val fields = it.split(";")
            val id: Long =  fields[0].toLong()
            val name: String = fields[1]
            customersList.add(CustomerDTO(id, name))
        }

        customerRepository!!.saveAll(customersList)
        val response = BulkInsertCustomerResponseDTO(insertCustomers.fileName, customersListResponse)
        return response
    }

    override fun findById(id: Long): CustomerDTO {
        return customerRepository!!.findById(id)
    }

    override fun save(customer: CustomerDTO): CustomerDTO {
        return customerRepository!!.save(customer)
    }
    override fun delete(customer: CustomerDTO) {
        customerRepository!!.delete(customer)
    }

    override fun getCustomersCount(): Int? {
        return customerRepository!!.getCustomersCount()
    }
}