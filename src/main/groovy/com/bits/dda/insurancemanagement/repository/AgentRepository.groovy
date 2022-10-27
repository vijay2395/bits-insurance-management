package com.bits.dda.insurancemanagement.repository

import com.bits.dda.insurancemanagement.entities.Agent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AgentRepository extends CrudRepository<Agent,Integer>{


}