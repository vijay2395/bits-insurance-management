package com.bits.dda.insurancemanagement.entities

import javax.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "policy")
 class Policy {
    @Id
    @Column(name = "Pol_ID", nullable = false)
     Integer id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Pol_Plan_ID", nullable = false)
     PolicyPlan polPlan

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Cust_ID", nullable = false)
     Customer cust

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Agent_ID", nullable = false)
     Agent agent

    @Column(name = "Pol_Desc", nullable = false, length = 50)
     String polDesc

    @Column(name = "Pol_Issue_Date", nullable = false)
     LocalDate polIssueDate

    @Column(name = "Pol_End_Date", nullable = false)
     LocalDate polEndDate

    @Column(name = "Pol_Premium_Amt", nullable = false, precision = 10, scale = 2)
     BigDecimal polPremiumAmt

    @Column(name = "Pol_Premium_Freq", nullable = false)
     Integer polPremiumFreq

    @Column(name = "Policy_Terms_Condns", length = 2000)
     String policyTermsCondns

    @Column(name = "Policy_Status", nullable = false, length = 10)
     String policyStatus

}