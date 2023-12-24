package io.winty.sec.acsprfservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.winty.sec.acsprfservices.model.UserProfile;

import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
    
    @Query(value = "SELECT COUNT(*) > 0 FROM user_profile up " +
            "JOIN access_profile ap " +
            "JOIN access_profile_transaction apt " +
            "JOIN transaction t " +
           "WHERE up.user_id = ?1 AND t.name = ?2", nativeQuery = true)
    boolean hasAccessToTransactionNative(UUID userId, String transactionName);
}