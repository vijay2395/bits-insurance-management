package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "manager")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class Manager {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "mgr_id", nullable = false)
     Integer managerId

////    @OneToMany(mappedBy = "reportingManagerId")
//    @OneToMany(mappedBy = "reportingManagerId", fetch = FetchType.LAZY, orphanRemoval = false)
//    List<Agent> agents

    @Column(name = "Mgr_FName", nullable = false, length = 50)
     String mgrFname

    @Column(name = "Mgr_LName", nullable = false, length = 50)
     String mgrLname

    @Column(name = "Mgr_Mobile", nullable = false, length = 15)
     String mgrMobile

    @Column(name = "Mgr_Landline", length = 15)
     String mgrLandline

    @Column(name = "Email_Address", nullable = false, length = 50)
     String emailAddress

    @Column(name = "Mgr_Dept", nullable = false, length = 10)
     String mgrDept

    @Column(name = "App_pwd", nullable = false, length = 15)
     String appPwd

}