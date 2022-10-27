package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "customer")
 class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Cust_ID", nullable = false)
     Integer id

    @Column(name = "Cust_FName", nullable = false, length = 50)
     String firstName

    @Column(name = "Cust_LName", nullable = false, length = 50)
     String lastName

    @Column(name = "Cust_Mobile", nullable = false, length = 15)
     String mobile

    @Column(name = "Cust_Landline", length = 15)
     String landline

    @Column(name = "Cust_Address", nullable = false, length = 50)
     String address

    @Column(name = "Cust_City", length = 20)
     String city

    @Column(name = "Cust_Pincode", length = 10)
     String pincode

    @Column(name = "Cust_State", nullable = false, length = 20)
     String state

    @Column(name = "Cust_Date_of_Birth", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dateOfBirth

    @Column(name = "Cust_Email", nullable = false, length = 50)
    String email

    @Column(name = "App_pwd", nullable = false, length = 15)
     String password

}