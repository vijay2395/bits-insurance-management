package com.bits.dda.insurancemanagement


import com.bits.dda.insurancemanagement.service.AppUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @Autowired
    AppUserService userService

    @GetMapping(path = "/")
    String greetings(){
     return 'Greetings from insurance-management api!'
    }

}
