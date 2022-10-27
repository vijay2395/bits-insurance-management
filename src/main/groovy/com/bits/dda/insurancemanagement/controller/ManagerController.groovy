package com.bits.dda.insurancemanagement.controller


import com.bits.dda.insurancemanagement.entities.Manager
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.ManagerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = "*")
class ManagerController {

    @Autowired
    ManagerService managerService

    @PostMapping(path = "/manager")
    ResponseEntity<Manager> createManager(@RequestBody Manager manager){
        Manager managerFromDb = managerService.createOrUpdateManager(manager)
        if(!managerFromDb){
            throw new RequestFailedException('Manager creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(managerFromDb)
    }

    @GetMapping(path = "/manager/{id}")
    ResponseEntity<Manager> getManagerById(@PathVariable('id') Integer id){
        Manager appUserFromDb = managerService.getManagerById(id)
        if(!appUserFromDb){
            throw new RequestFailedException("Unable to find manager with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(appUserFromDb)
    }

    @GetMapping(path = "/manager")
    ResponseEntity<List<Manager>> getAllManagers(){
        List<Manager> managerList = managerService.getAllManagers()
//        if(!(managerList.size() > 0))
//            throw new RequestFailedException("Unable to find manager with id: {$id}", HttpStatus.NOT_FOUND)
//        }
        return ResponseEntity.ok(managerList)
    }
}
