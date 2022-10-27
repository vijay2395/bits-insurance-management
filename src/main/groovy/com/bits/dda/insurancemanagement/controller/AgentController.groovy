package com.bits.dda.insurancemanagement.controller

import com.bits.dda.insurancemanagement.entities.Agent
import com.bits.dda.insurancemanagement.exception.RequestFailedException
import com.bits.dda.insurancemanagement.service.AgentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AgentController {

    @Autowired
    AgentService agentService

    @PostMapping(path = "/agent")
    ResponseEntity<Agent> createAgent(@RequestBody Agent agent){
        Agent agentFromDb = agentService.createOrUpdateAgent(agent)
        if(!agentFromDb){
            throw new RequestFailedException('agent creation failed!', HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok(agentFromDb)
    }

    @GetMapping(path = "/agent/{id}")
    ResponseEntity<Agent> getAgentById(@PathVariable('id') Integer id){
        Agent agentFromDb = agentService.getAgentById(id)
        if(!agentFromDb){
            throw new RequestFailedException("Unable to find agent with id: {$id}", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity.ok(agentFromDb)
    }
}
