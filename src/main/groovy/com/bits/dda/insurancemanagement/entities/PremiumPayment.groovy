package com.bits.dda.insurancemanagement.entities

import javax.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "premium_payment")
 class PremiumPayment {
    @Id
    @Column(name = "Pay_Ref_ID", nullable = false)
    private Integer id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Pol_ID", nullable = false)
    private Policy pol

    @Column(name = "Pay_Date", nullable = false)
    private LocalDate payDate

    @Column(name = "Pay_Prem_Amt", nullable = false, precision = 10, scale = 2)
    private BigDecimal payPremAmt

    @Column(name = "Pay_Desc", nullable = false, length = 50)
    private String payDesc


}