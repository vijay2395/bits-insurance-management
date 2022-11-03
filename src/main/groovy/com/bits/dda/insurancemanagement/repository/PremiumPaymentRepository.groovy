package com.bits.dda.insurancemanagement.repository

import com.bits.dda.insurancemanagement.entities.PremiumPayment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PremiumPaymentRepository extends CrudRepository<PremiumPayment,Integer>{

}