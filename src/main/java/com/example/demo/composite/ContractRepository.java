package com.example.demo.composite;

import com.example.demo.composite.model.Contract;
import com.example.demo.composite.model.ContractId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD;

@Repository
public interface ContractRepository extends CrudRepository<Contract, ContractId> {

    @Override
    @EntityGraph(value = "Contract.detail", type = LOAD)
    Iterable<Contract> findAll();
}
