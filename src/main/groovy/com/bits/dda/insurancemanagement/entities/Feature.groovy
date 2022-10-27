package com.bits.dda.insurancemanagement.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "features")
 class Feature {
    @Id
    @Column(name = "Feature_ID", nullable = false)
     Integer id;

    @Column(name = "Feature_Name", nullable = false, length = 30)
     String featureName;

}