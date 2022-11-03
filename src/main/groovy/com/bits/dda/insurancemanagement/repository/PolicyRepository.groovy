package com.bits.dda.insurancemanagement.repository

import com.bits.dda.insurancemanagement.entities.Policy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PolicyRepository extends CrudRepository<Policy,Integer>{


}