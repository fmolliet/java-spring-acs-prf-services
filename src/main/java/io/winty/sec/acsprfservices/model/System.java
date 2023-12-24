package io.winty.sec.acsprfservices.model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system")
public class System implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "system_id", updatable = false, nullable = false)
    private UUID systemId;

    @Column(name = "system_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
    
    public System(String name, String description) {
        this.name = name;
        this.description = description;
    }

}