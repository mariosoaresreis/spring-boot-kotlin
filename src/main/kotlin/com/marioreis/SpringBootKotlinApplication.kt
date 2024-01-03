package com.marioreis

import com.marioreis.infrastructure.adapters.entities.CustomerEntity
import com.marioreis.infrastructure.adapters.repositories.CustomerRepositorySpringBoot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [CustomerRepositorySpringBoot::class, CustomerEntity::class])
@EntityScan(basePackageClasses = [CustomerEntity::class])
@Configuration
class SpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}
