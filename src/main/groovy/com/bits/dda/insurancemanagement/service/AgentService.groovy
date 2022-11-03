package com.bits.dda.insurancemanagement.service

import com.bits.dda.insurancemanagement.entities.Agent
import com.bits.dda.insurancemanagement.entities.Manager
import com.bits.dda.insurancemanagement.repository.AgentRepository
import com.bits.dda.insurancemanagement.repository.ManagerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AgentService {

    @Autowired
    AgentRepository agentRepository

     Agent getAgentById(Integer id) {
        Optional<Agent> agent = agentRepository.findById(id)
         if(!agent.isEmpty()){
             agent.get().reportingManagerId = agent.get().manager.managerId
             return agent.get()
         }
         return null
    }
    List<Agent> getAllAgents() {
        List<Agent> agent = agentRepository.findAll().collect()
        if(!agent.isEmpty()){
            agent = agent.each {
                it.reportingManagerId = it.manager.managerId
            }
            return agent

        }

        return null
    }

    @Autowired
    ManagerRepository managerRepository

     Agent createOrUpdateAgent(Agent agent) {
         Agent agent1 = null
        Optional<Manager> managerOptional =  managerRepository.findById(agent.reportingManagerId)
         if(managerOptional.isPresent()){
             agent.manager = managerOptional.get()
             agent1 =  agentRepository.save(agent)
             agent1.reportingManagerId = agent1.manager.managerId
         }
         return agent1
     }
}
