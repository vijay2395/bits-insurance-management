package com.bits.dda.insurancemanagement.controller

import com.bits.dda.insurancemanagement.entities.Policy
import com.bits.dda.insurancemanagement.entities.PolicyPlan
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.PolicyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = "*")
class PolicyController {

    @Autowired
    PolicyService policyService

    @PostMapping(path = "/policy")
    ResponseEntity<Policy> createPolicyPlan(@RequestBody Policy policy){
        Policy policyFromDb = policyService.createOrUpdatePolicy(policy)
        if(!policyFromDb){
            throw new RequestFailedException('Policy creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(policyFromDb)
    }

    @GetMapping(path = "/policy/{id}")
    ResponseEntity<Policy> gePolicyPlanById(@PathVariable('id') Integer id){
        Policy policyFromDb = policyService.getPolicyById(id)
        if(!policyFromDb){
            throw new RequestFailedException("Unable to find policy with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(policyFromDb)
    }

    @GetMapping(path = "/policy")
    ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policyList = policyService.getAllPolicies()
        return ResponseEntity.ok(policyList)
    }
}
