package com.bits.dda.insurancemanagement.repository


import com.bits.dda.insurancemanagement.entities.PolicyPlan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PolicyPlanRepository extends CrudRepository<PolicyPlan,Integer>{


}