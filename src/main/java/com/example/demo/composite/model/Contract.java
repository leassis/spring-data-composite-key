package com.example.demo.composite.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "contract_composite")
@Data
@Table(name = "contract_composite")
@NamedEntityGraph(
        name = "Contract.detail",
        attributeNodes = {@NamedAttributeNode(value = "id",subgraph = "contractCompositeId")},
        subgraphs = {
                @NamedSubgraph(
                        name = "contractCompositeId",
                        attributeNodes = {
                                @NamedAttributeNode(value = "student"),
                                @NamedAttributeNode(value = "course")
                        }
                )
        }
)
public class Contract {
    @EmbeddedId
    private ContractId id;

    private LocalDateTime issued;
}
