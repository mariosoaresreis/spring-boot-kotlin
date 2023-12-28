package com.marioreis.domain.ports.repositories

import com.marioreis.domain.dto.CustomerDTO

interface CustomerRepositoryPort {
    fun saveAll(customers: List<CustomerDTO>)
}