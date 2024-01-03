package com.marioreis.domain.dto

data class BulkInsertCustomerResponseDetailDTO (
    val lineNumber: Integer,
    val lineContent: String,
    val validationErrors: List<String>
)