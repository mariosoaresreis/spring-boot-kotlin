package com.marioreis.application.adapters.controllers

import com.marioreis.domain.dto.BulkInsertCostumerRequestDTO
import com.marioreis.domain.dto.BulkInsertCustomerResponseDTO
import com.marioreis.domain.dto.CustomerDTO
import com.marioreis.domain.ports.interfaces.CustomerServicePort
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1")
@Validated
class CustomerController(val customerService: CustomerServicePort) {
    @PostMapping("/bulkInsert/customers")
    @ResponseStatus(HttpStatus.CREATED)
    fun bulkInsertCustomers(@RequestBody @Valid insertCostumerRequest: BulkInsertCostumerRequestDTO ): BulkInsertCustomerResponseDTO {
        return customerService.bulkInsertCustomers(insertCostumerRequest)
    }
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    fun saveCustomer(@RequestBody @Valid customer: CustomerDTO ) = customerService.save(customer)

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomer(@PathVariable @Valid id: Long ) = customerService.findById(id)

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable @Valid id: Long ) {
        val customer = customerService.findById(id)
        customerService.delete(customer)
    }

    @GetMapping("/customers/count")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomersCount(): Int? = customerService.getCustomersCount()
}