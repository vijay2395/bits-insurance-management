package com.bits.dda.insurancemanagement.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "policy_plan")
 class PolicyPlan {
    @Id
    @Column(name = "Policy_Plan_ID", nullable = false)
     Integer id

    @Column(name = "Policy_Plan_Name", nullable = false, length = 50)
     String policyPlanName

    @Column(name = "Policy_Plan_Type", nullable = false, length = 30)
     String policyPlanType

    @Column(name = "Policy_Term", nullable = false, precision = 5, scale = 1)
     BigDecimal policyTerm

    @Column(name = "Commission_percent", precision = 5, scale = 2)
     BigDecimal commissionPercent

}