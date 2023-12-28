package com.marioreis.domain.dto

data class InsertCustomerResponseDetailDTO (
    val lineNumber: Integer,
    val lineContent: String,
    val validationErrors: List<String>
)