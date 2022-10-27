package com.bits.dda.insurancemanagement.entities

import javax.persistence.*

@Entity
@Table(name = "agent")
 class Agent {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Agent_ID", nullable = false)
     Integer id

    @Column(name = "Agent_FName", nullable = false, length = 50)
     String agentFname

    @Column(name = "Agent_LName", nullable = false, length = 50)
     String agentLname

    @Column(name = "Agent_Mobile", nullable = false, length = 15)
     String agentMobile

    @Column(name = "Agent_Landline", length = 15)
     String agentLandline

    @Column(name = "Email_Address", nullable = false, length = 50)
     String emailAddress

    @Column(name = "Office_Phone", length = 15)
     String officePhone

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Reporting_Mgr_ID", nullable = false)
    //@Column(name = "Reporting_Mgr_ID", nullable = false, length = 15)
    Manager reportingMgr

    @Column(name = "App_pwd", nullable = false, length = 15)
     String appPwd

}