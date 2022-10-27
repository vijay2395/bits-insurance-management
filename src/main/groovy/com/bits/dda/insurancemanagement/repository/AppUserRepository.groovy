package com.bits.dda.insurancemanagement.repository

import com.bits.dda.insurancemanagement.entities.AppUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AppUserRepository extends CrudRepository<AppUser,Integer>{


}