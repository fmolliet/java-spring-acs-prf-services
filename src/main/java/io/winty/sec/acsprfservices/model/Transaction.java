package io.winty.sec.acsprfservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {
    
    private static final long serialVersionUID = 11L;
    
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "transaction_name", nullable = false)
    private String transactionName;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "parent_name")
    private Transaction parent;
}