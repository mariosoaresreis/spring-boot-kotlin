package com.marioreis.application.adapters.controllers

import com.marioreis.domain.dto.InsertCostumerRequestDTO
import com.marioreis.domain.dto.InsertCustomerResponseDTO
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/customers")
@Validated
class CustomerController(val customerService: CustomerServicePort) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCustomer(@RequestBody @Valid insertCostumerRequest: InsertCostumerRequestDTO ): InsertCustomerResponseDTO {
        return customerService.insertCustomers(insertCostumerRequest)
    }

}