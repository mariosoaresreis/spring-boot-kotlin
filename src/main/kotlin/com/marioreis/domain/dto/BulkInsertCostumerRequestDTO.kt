package com.marioreis.domain.dto

import javax.validation.constraints.NotNull

data class BulkInsertCostumerRequestDTO (
    @get:NotNull(message = "InsertCostumerDTO.customers must not be null")
    val customers: List<String>,
    @get:NotNull(message = "InsertCostumerDTO.fileName must not be null")
    val fileName: String
)