package com.marioreis.domain.ports.interfaces

import com.marioreis.domain.dto.InsertCostumerRequestDTO
import com.marioreis.domain.dto.InsertCustomerResponseDTO

interface CustomerServicePort {
    fun insertCustomers(customers: InsertCostumerRequestDTO): InsertCustomerResponseDTO
}