package com.bits.dda.insurancemanagement.entities

import javax.persistence.*

@Entity
@Table(name = "app_users")
 class AppUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "App_User_ID", nullable = false)
     Integer id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Role_ID", nullable = false)
     Role role

    @Column(name = "User_Entity_Ref_ID", nullable = false)
     Integer userEntityRefId

    @Column(name = "Username", nullable = false, length = 15)
     String username

    @Column(name = "Password", nullable = false, length = 15)
     String password

}