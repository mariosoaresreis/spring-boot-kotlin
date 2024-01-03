package com.marioreis.domain.dto

data class BulkInsertCustomerResponseDTO (
    val fileName: String,
    val customers: List<BulkInsertCustomerResponseDetailDTO>
)