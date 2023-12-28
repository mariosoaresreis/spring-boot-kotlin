package com.marioreis.domain.dto

data class InsertCustomerResponseDTO (
    val fileName: String,
    val customers: List<InsertCustomerResponseDetailDTO>
)