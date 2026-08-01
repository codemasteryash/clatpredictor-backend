package com.clatpredictor.api.repository;

import com.clatpredictor.api.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    Optional<Program> findByName(String name);
}
