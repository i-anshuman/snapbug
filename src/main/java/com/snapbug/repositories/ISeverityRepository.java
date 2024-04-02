package com.snapbug.repositories;

import com.snapbug.entities.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeverityRepository extends JpaRepository<Severity, Long> {
}
