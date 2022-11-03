package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "premium_payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class PremiumPayment {
    @Id
    @Column(name = "Pay_Ref_ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Pol_ID", nullable = false)
    private Policy policyId

    @Column(name = "Pay_Date", nullable = false)
    private LocalDate paymentDate

    @Column(name = "Pay_Prem_Amt", nullable = false, precision = 10, scale = 2)
    private BigDecimal paymentAmount

    @Column(name = "Pay_Desc", nullable = false, length = 50)
    private String paymentDescription


}