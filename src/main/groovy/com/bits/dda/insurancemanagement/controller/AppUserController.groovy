package com.bits.dda.insurancemanagement.controller


import com.bits.dda.insurancemanagement.entities.AppUser
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.AppUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = "*")
class AppUserController {

    @Autowired
    AppUserService userService

    @PostMapping(path = "/user")
    ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser){
        AppUser appUserFromDb = userService.createOrUpdateAppUser(appUser)
        if(!appUserFromDb){
            throw new RequestFailedException('app user creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(appUserFromDb)
    }

    @GetMapping(path = "/user/{id}")
    ResponseEntity<AppUser> getUserById(@PathVariable('id') Integer id){
        AppUser appUserFromDb = userService.getAppUserById(id)
        if(!appUserFromDb){
            throw new RequestFailedException("Unable to find app user with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(appUserFromDb)
    }
}
