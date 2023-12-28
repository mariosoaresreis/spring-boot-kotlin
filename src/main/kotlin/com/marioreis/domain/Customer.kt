package com.marioreis.domain

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class Customer (
    @get:NotNull(message = "Customer.id must not be null")
    val id: Long,
    @get:NotBlank(message = "Customer.name must not be null")
    val name: String
)
