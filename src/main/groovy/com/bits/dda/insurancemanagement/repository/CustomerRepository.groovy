package com.bits.dda.insurancemanagement.repository


import com.bits.dda.insurancemanagement.entities.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository extends CrudRepository<Customer,Integer>{


}