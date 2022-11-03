package com.bits.dda.insurancemanagement.controller

import com.bits.dda.insurancemanagement.entities.Policy
import com.bits.dda.insurancemanagement.entities.PremiumPayment
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.repository.PremiumPaymentRepository
import com.bits.dda.insurancemanagement.service.PolicyService
import com.bits.dda.insurancemanagement.service.PremiumPaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = "*")
class PremiumPaymentController {

    @Autowired
    PremiumPaymentService premiumPaymentService

    @PostMapping(path = "/premiumPayment")
    ResponseEntity<PremiumPayment> createPremiumPayment(@RequestBody PremiumPayment premiumPayment){
        PremiumPayment premiumPaymentFromDb = premiumPaymentService.createOrUpdatePremiumPayment(premiumPayment)
        if(!premiumPaymentFromDb){
            throw new RequestFailedException('Premium payment creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(premiumPaymentFromDb)
    }

    @GetMapping(path = "/premiumPayment/{id}")
    ResponseEntity<PremiumPayment> gePolicyPlanById(@PathVariable('id') Integer id){
        PremiumPayment premiumPaymentFromDb = premiumPaymentService.getPreimumPaymentById(id)
        if(!premiumPaymentFromDb){
            throw new RequestFailedException("Unable to find policy with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(premiumPaymentFromDb)
    }
}
