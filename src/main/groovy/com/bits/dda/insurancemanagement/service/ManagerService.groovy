package com.bits.dda.insurancemanagement.service


import com.bits.dda.insurancemanagement.entities.Manager
import com.bits.dda.insurancemanagement.repository.ManagerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ManagerService {

    @Autowired
    ManagerRepository managerRepository

    Manager getManagerById(Integer id) {
        Optional<Manager> manager = managerRepository.findById(id)
         if(!manager.isEmpty()){
             return manager.get()
         }
         return null
    }

    List<Manager> getAllManagers() {
        List<Manager> managerList = managerRepository.findAll().collect()
        if(managerList.size() > 0 ){
            return managerList
        }
        return null
    }

    Manager createOrUpdateManager(Manager appUser) {
        managerRepository.save(appUser)
     }
}
