package io.winty.sec.acsprfservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.winty.sec.acsprfservices.model.AccessProfileTransaction;

@Repository
public interface AccessProfileTransactionRepository extends JpaRepository<AccessProfileTransaction, String> {
}
