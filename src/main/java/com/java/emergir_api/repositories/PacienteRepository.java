package com.java.emergir_api.repositories;

import com.java.emergir_api.domain.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
