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
@IdClass(AccessProfileTransactionId.class)
@Table(name = "access_profile_transaction")
public class AccessProfileTransaction implements Serializable{
    
    private static final long serialVersionUID = 3L;

    @Id
    @ManyToOne
    @JoinColumn(name = "access_profile_name")
    private AccessProfile accessProfile;

    @Id
    @ManyToOne
    @JoinColumn(name = "transaction_name")
    private Transaction transaction;

}