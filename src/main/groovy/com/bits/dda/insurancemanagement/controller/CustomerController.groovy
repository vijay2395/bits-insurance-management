package com.bits.dda.insurancemanagement.controller


import com.bits.dda.insurancemanagement.entities.Customer
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = "*")
class CustomerController {

    @Autowired
    CustomerService customerService

    @GetMapping(path = "/customer")
    ResponseEntity<List<Customer>> getallCustomers(){
        List<Customer> customerFromDb = customerService.getAllCustomers()
        if(!customerFromDb){
            throw new RequestFailedException('customer creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(customerFromDb)
    }

    @PostMapping(path = "/customer")
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerFromDb = customerService.createOrUpdateCustomer(customer)
        if(!customerFromDb){
            throw new RequestFailedException('customer creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(customerFromDb)
    }

    @GetMapping(path = "/customer/{id}")
    ResponseEntity<Customer> getUserById(@PathVariable('id') Integer id){
        Customer customerFromDb = customerService.getCustomerById(id)
        if(!customerFromDb){
            throw new RequestFailedException("Unable to find customer with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(customerFromDb)
    }
}
