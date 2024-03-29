package com.snapbug.services;

import com.snapbug.dtos.IssueCreationDTO;
import com.snapbug.dtos.IssueDTO;
import com.snapbug.dtos.IssueDetailDTO;
import com.snapbug.dtos.IssueListDTO;
import com.snapbug.dtos.PageDTO;
import com.snapbug.entities.Issue;
import com.snapbug.entities.Status;
import com.snapbug.entities.User;
import com.snapbug.exceptions.IssueException;
import com.snapbug.mappers.IssueMapper;
import com.snapbug.repositories.IIssueRepository;
import com.snapbug.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IssueService implements IIssueService {

  private final IIssueRepository issueRepository;
  private final IssueMapper issueMapper;

  @Value("${issue.not.found}")
  private String issueNotFound;

  @Autowired
  public IssueService(IIssueRepository issueRepository, IssueMapper issueMapper) {
    this.issueRepository = issueRepository;
    this.issueMapper = issueMapper;
  }

  @Override
  public IssueDTO create(IssueCreationDTO issue) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    final UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
    final Issue model = issueMapper.dtoToModel(issue);
    model.setReporter(User.builder().id(user.getId()).build());
    model.setStatus(Status.builder().id(1L).build());
    return issueMapper.modelToDto(issueRepository.save(model));
  }

  @Override
  public void delete(Long id) {
    issueRepository.deleteById(id);
  }

  @Override
  public PageDTO<List<IssueListDTO>> getAll(int page, int size) {
    final Page<IssueListDTO> issue = issueRepository.getAllIssues(PageRequest.of(page, size, Sort.by("reportedOn").descending()));
    return PageDTO.<List<IssueListDTO>>builder()
            .content(issue.getContent())
            .totalElements(issue.getTotalElements())
            .totalPages(issue.getTotalPages())
            .build();
  }

  @Override
  public IssueDetailDTO getIssue(Long issueId) {
    return issueRepository
            .getIssue(issueId)
            .orElseThrow(() -> new IssueException(issueNotFound, HttpStatus.NOT_FOUND));
  }

  @Override
  public List<Issue> getByReporter(User reporter) {
    return issueRepository.findAllByReporter(reporter);
  }
}
