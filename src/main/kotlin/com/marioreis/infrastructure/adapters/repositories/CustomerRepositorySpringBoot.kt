package com.marioreis.infrastructure.adapters.repositories

import com.marioreis.infrastructure.adapters.entities.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepositorySpringBoot: JpaRepository<CustomerEntity, Long> {
}