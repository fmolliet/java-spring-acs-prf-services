package io.winty.sec.acsprfservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.winty.sec.acsprfservices.model.System;

import java.util.UUID;

@Repository
public interface SystemRepository extends JpaRepository<System, UUID> {
}