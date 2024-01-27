package com.snapbug.repositories;

import com.snapbug.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {
}
