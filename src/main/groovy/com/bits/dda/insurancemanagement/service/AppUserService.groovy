package com.bits.dda.insurancemanagement.service

import com.bits.dda.insurancemanagement.entities.AppUser
import com.bits.dda.insurancemanagement.repository.AppUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AppUserService {

    @Autowired
    AppUserRepository appUserRepository

     AppUser getAppUserById(Integer id) {
        Optional<AppUser> appUser = appUserRepository.findById(id)
         if(!appUser.isEmpty()){
             return appUser.get()
         }
         return null
    }

     AppUser createOrUpdateAppUser(AppUser appUser) {
         appUserRepository.save(appUser)
     }
}
