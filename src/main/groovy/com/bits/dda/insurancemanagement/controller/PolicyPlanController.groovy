package com.bits.dda.insurancemanagement.controller


import com.bits.dda.insurancemanagement.entities.PolicyPlan
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.PolicyPlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PolicyPlanController {

    @Autowired
    PolicyPlanService policyPlanService

    @PostMapping(path = "/policyPlan")
    ResponseEntity<PolicyPlan> createPolicyPlan(@RequestBody PolicyPlan policyPlan){
        PolicyPlan policyPlanFromDb = policyPlanService.createOrUpdatePolicyPlan(policyPlan)
        if(!policyPlanFromDb){
            throw new RequestFailedException('Policy plan creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(policyPlanFromDb)
    }

    @GetMapping(path = "/policyPlan/{id}")
    ResponseEntity<PolicyPlan> gePolicyPlanById(@PathVariable('id') Integer id){
        PolicyPlan policyPlanFromDb = policyPlanService.getPolicyPlanById(id)
        if(!policyPlanFromDb){
            throw new RequestFailedException("Unable to find policy plan with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(policyPlanFromDb)
    }
}
