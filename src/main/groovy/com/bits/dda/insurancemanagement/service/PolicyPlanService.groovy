package com.bits.dda.insurancemanagement.service


import com.bits.dda.insurancemanagement.entities.PolicyPlan
import com.bits.dda.insurancemanagement.repository.PolicyPlanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PolicyPlanService {

    @Autowired
    PolicyPlanRepository policyPlanRepository

    PolicyPlan getPolicyPlanById(Integer id) {
        Optional<PolicyPlan> policyPlan = policyPlanRepository.findById(id)
         if(!policyPlan.isEmpty()){
             return policyPlan.get()
         }
        return null
    }

    PolicyPlan createOrUpdatePolicyPlan(PolicyPlan policyPlan) {
        policyPlanRepository.save(policyPlan)
     }
}
