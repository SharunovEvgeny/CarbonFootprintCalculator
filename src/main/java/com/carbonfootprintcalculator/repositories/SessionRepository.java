package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
	Optional<Session> findFirstByOrderByIdDesc();
}
