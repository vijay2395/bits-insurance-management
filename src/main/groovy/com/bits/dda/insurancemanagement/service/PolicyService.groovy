package com.bits.dda.insurancemanagement.service

import com.bits.dda.insurancemanagement.entities.Agent
import com.bits.dda.insurancemanagement.entities.Customer
import com.bits.dda.insurancemanagement.entities.Policy
import com.bits.dda.insurancemanagement.entities.PolicyPlan
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.repository.AgentRepository
import com.bits.dda.insurancemanagement.repository.CustomerRepository
import com.bits.dda.insurancemanagement.repository.PolicyPlanRepository
import com.bits.dda.insurancemanagement.repository.PolicyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class PolicyService {

    @Autowired
    PolicyRepository policyRepository

    Policy getPolicyById(Integer id) {
        Optional<Policy> policy = policyRepository.findById(id)
         if(!policy.isEmpty()){
             policy.get().agentid = policy.get().agent.agentId
             policy.get().customerId = policy.get().customer.customerId
             policy.get().policyPlanId = policy.get().policyPlan.policyPlanId
             return policy.get()
         }
        return null
    }

    @Autowired
    PolicyPlanRepository policyPlanRepository

    @Autowired
    CustomerRepository customerRepository

    @Autowired
    AgentRepository agentRepository

    Policy createOrUpdatePolicy(Policy policy) {
        PolicyPlan policyPlan = policyPlanRepository.findById(policy.policyPlanId).get()
        Optional<Customer> customer = customerRepository.findById(policy.customerId)
        if(!customer.isPresent()){
            throw new RequestFailedException("Customer Id does not exists  in the database: {$policy.customerId}", HttpStatus.BAD_REQUEST)
        }

        Agent agent = agentRepository.findById(policy.agentid).get()

        policy.agent = agent
        policy.customer = customer
        policy.policyPlan = policyPlan

        policyRepository.save(policy)
     }

    List<Policy> getAllPolicies() {
        List<Policy> policyList = policyRepository.findAll().collect()
         policyList = policyList.each {
            it.policyPlanId = it.policyPlan.policyPlanId
            it.agentid = it.agent.agentId
            it.customerId = it.customer.customerId
        }
        if(policyList.size() > 0 ){
            return policyList
        }
        return null
    }

}
