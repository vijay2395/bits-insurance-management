package com.bits.dda.insurancemanagement.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "role")
 class Role {
    @Id
    @Column(name = "Role_ID", nullable = false)
     Integer id

    @Column(name = "Role_Name", nullable = false, length = 10)
     String roleName

    @Column(name = "Role_Desc", length = 50)
     String roleDesc

}