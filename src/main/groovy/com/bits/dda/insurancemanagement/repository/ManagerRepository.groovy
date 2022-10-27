package com.bits.dda.insurancemanagement.repository


import com.bits.dda.insurancemanagement.entities.Manager
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ManagerRepository extends CrudRepository<Manager,Integer>{

}