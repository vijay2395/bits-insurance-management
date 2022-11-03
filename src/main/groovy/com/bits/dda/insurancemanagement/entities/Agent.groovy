package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.OnDelete

import javax.persistence.*

@Entity
@Table(name = "agent")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class Agent {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "Agent_ID", nullable = false)
     Integer agentId

    @Column(name = "Agent_FName", nullable = false, length = 50)
     String firstName

    @Column(name = "Agent_LName", nullable = false, length = 50)
     String lastName

    @Column(name = "Agent_Mobile", nullable = false, length = 15)
     String mobileNumber

    @Column(name = "Agent_Landline", length = 15)
     String landlineNumber

    @Column(name = "Email_Address", nullable = false, length = 50)
     String email

    @Column(name = "Office_Phone", length = 15)
     String officePhone

//    @Column(name = "Reporting_Mgr_ID")
    Integer reportingManagerId

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Reporting_Mgr_ID", nullable = false)
    @JsonIgnore
    Manager manager

    @Column(name = "App_pwd", nullable = false, length = 15)
     String password

}