package com.marioreis.application.adapters.controllers

import com.marioreis.domain.dto.BulkInsertCostumerRequestDTO
import com.marioreis.domain.dto.BulkInsertCustomerResponseDTO
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/bulkInsert/customers")
@Validated
class CustomerController(val customerService: CustomerServicePort) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun bulkInsertCustomers(@RequestBody @Valid insertCostumerRequest: BulkInsertCostumerRequestDTO ): BulkInsertCustomerResponseDTO {
        return customerService.insertCustomers(insertCostumerRequest)
    }

    @GetMapping("/v1/customers/count")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomersCount(): Int? {
        return customerService.getCustomersCount()
    }

}