package com.snapbug.repositories;

import com.snapbug.dtos.IssueDetailDTO;
import com.snapbug.dtos.IssueListDTO;
import com.snapbug.entities.Issue;
import com.snapbug.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IIssueRepository extends JpaRepository<Issue, Long> {
  List<Issue> findAllByReporter(User reporter);
  Page<IssueListDTO> getAllIssues(Pageable page);
  Optional<IssueDetailDTO> getIssue(Long issueId);
}
