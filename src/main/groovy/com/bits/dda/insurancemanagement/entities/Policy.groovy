package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "policy")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class Policy {
    @Id
    @Column(name = "Pol_ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer policyId

    Integer policyPlanId

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Pol_Plan_ID", nullable = false)
    @JsonIgnore
     PolicyPlan policyPlan

    Integer customerId

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Cust_ID", nullable = false)
    @JsonIgnore
     Customer customer

    Integer agentid

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Agent_ID", nullable = false)
    @JsonIgnore
    Agent agent

    @Column(name = "Pol_Desc", nullable = false, length = 50)
     String policyDescription

    @Column(name = "Pol_Issue_Date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate policyIssueDate

    @Column(name = "Pol_End_Date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate policyEndDate

    @Column(name = "Pol_Premium_Amt", nullable = false, precision = 10, scale = 2)
     BigDecimal policyPremiumAmount

    @Column(name = "Pol_Premium_Freq", nullable = false)
     Integer policyPremiumFrequency

    @Column(name = "Policy_Terms_Condns", length = 2000)
     String termsAndConditions

    @Column(name = "Policy_Status", nullable = false, length = 10)
     String policyStatus

}