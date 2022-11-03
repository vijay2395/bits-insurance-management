package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.*

@Entity
@Table(name = "role_authorization")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class RoleAuthorization {
    @Id
    @Column(name = "Auth_ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Role_ID", nullable = false)
    private Role role

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Feature_ID", nullable = false)
    private Feature feature

    @Column(name = "Access_Level", nullable = false, length = 3)
    private String accessLevel


}