package com.bits.dda.insurancemanagement.entities

import com.fasterxml.jackson.annotation.JsonInclude

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "features")
@JsonInclude(JsonInclude.Include.NON_NULL)
 class Feature {
    @Id
    @Column(name = "Feature_ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Feature_Name", nullable = false, length = 30)
     String featureName;

}