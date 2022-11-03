package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class Role {
    @Id
    @Column(name = "Role_ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id

    @Column(name = "Role_Name", nullable = false, length = 10)
     String roleName

    @Column(name = "Role_Desc", length = 50)
     String roleDesc

}