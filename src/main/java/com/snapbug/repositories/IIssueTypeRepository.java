package com.snapbug.repositories;

import com.snapbug.entities.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIssueTypeRepository extends JpaRepository<IssueType, Long> {
}
