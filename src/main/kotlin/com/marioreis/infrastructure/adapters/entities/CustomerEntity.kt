package com.marioreis.infrastructure.adapters.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id

@Entity
@Table(name = "customers")
class CustomerEntity{
    @Id
    var id: Long? = null
    var name: String? = null

    constructor(){

    }

    constructor(id: Long, name: String){
        this.id = id
        this.name = name
    }
}