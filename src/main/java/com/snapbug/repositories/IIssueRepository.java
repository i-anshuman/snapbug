package com.snapbug.repositories;

import com.snapbug.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIssueRepository extends JpaRepository<Issue, Long> {
}
