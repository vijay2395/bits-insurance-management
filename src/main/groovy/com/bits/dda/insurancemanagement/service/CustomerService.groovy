package com.bits.dda.insurancemanagement.service


import com.bits.dda.insurancemanagement.entities.Customer
import com.bits.dda.insurancemanagement.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    CustomerRepository customerRepository

    Customer getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id)
         if(!customer.isEmpty()){
             return customer.get()
         }
        return null
    }

    Customer createOrUpdateCustomer(Customer customer) {
         customerRepository.save(customer)
     }
}
