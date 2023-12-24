package io.winty.sec.acsprfservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable  {
    
    private static final long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "profile_id", updatable = false, nullable = false)
    private UUID profileId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SystemUser user;

    @ManyToOne
    @JoinColumn(name = "access_profile_name")
    private AccessProfile accessProfile;
    
    public UserProfile(SystemUser user, AccessProfile profile) {
        this.user = user;
        accessProfile = profile;
    }
}
