package com.marioreis.domain.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CustomerDTO (
    @get:NotNull(message = "CustomerDTO.id must not be null")
    val id: Long,
    @get:NotBlank(message = "CustomerDTO.name must not be blank")
    val name: String
)
