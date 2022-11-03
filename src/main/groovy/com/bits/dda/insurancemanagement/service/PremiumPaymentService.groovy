package com.bits.dda.insurancemanagement.service

import com.bits.dda.insurancemanagement.entities.PremiumPayment
import com.bits.dda.insurancemanagement.repository.PremiumPaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PremiumPaymentService {

    @Autowired
    PremiumPaymentRepository premiumPaymentRepository

    PremiumPayment getPreimumPaymentById(Integer id) {
        Optional<PremiumPayment> premiumPayment = premiumPaymentRepository.findById(id)
         if(!premiumPayment.isEmpty()){
             return premiumPayment.get()
         }
        return null
    }

    PremiumPayment createOrUpdatePremiumPayment(PremiumPayment premiumPayment) {
        premiumPaymentRepository.save(premiumPayment)
     }
}
