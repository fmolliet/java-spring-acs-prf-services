package io.winty.sec.acsprfservices.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import io.winty.sec.acsprfservices.model.AccessProfile;
import io.winty.sec.acsprfservices.model.AccessProfileTransaction;
import io.winty.sec.acsprfservices.model.Transaction;
import io.winty.sec.acsprfservices.model.SystemUser;
import io.winty.sec.acsprfservices.model.System;
import io.winty.sec.acsprfservices.model.UserProfile;
import io.winty.sec.acsprfservices.repositories.UserProfileRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
public class UserProfileRepositoryTests {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Test
    public void shouldReturnTrueWhenUserHasAccessToTransaction() {
        SystemUser user = new SystemUser("teste", "teste@ghasda.com","abacate" ); 
        entityManager.persist(user);

        System system = new System("SYSTEM_NAME", "DESCRIPTION");
        
        entityManager.persist(system);
        
        AccessProfile profile = new AccessProfile("PROFILE_X", "Profile X", system); 
        entityManager.persist(profile);

        Transaction transaction = new Transaction("TRANSCAO", "transaction_name", "HOT", null);
        entityManager.persist(transaction);

        UserProfile userProfile = new UserProfile(user, profile);
        entityManager.persist(userProfile);

        AccessProfileTransaction accessProfileTransaction = new AccessProfileTransaction(profile, transaction);
        entityManager.persist(accessProfileTransaction);

        entityManager.flush();

        boolean hasAccess = userProfileRepository.hasAccessToTransactionNative(user.getUserId(), transaction.getName());
        assertThat(hasAccess).isTrue();
    }
    
}
