package com.bits.dda.insurancemanagement.service

import com.bits.dda.insurancemanagement.entities.Agent
import com.bits.dda.insurancemanagement.repository.AgentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AgentService {

    @Autowired
    AgentRepository agentRepository

     Agent getAgentById(Integer id) {
        Optional<Agent> agent = agentRepository.findById(id)
         if(!agent.isEmpty()){
             return agent.get()
         }
         return null
    }

     Agent createOrUpdateAgent(Agent agent) {
         agentRepository.save(agent)
     }
}
