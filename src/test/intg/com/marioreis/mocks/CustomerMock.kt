package com.marioreis.mocks

import com.marioreis.domain.dto.CustomerDTO

object CustomerMock {
    const val CUSTOMER_ID = 15640997095L
    fun getCustomerMock(): CustomerDTO = CustomerDTO(CUSTOMER_ID, "CUSTOMER 1")
}