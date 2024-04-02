package com.snapbug.services;

import com.snapbug.dtos.IssueTypeCreationDTO;
import com.snapbug.dtos.IssueTypeDTO;
import com.snapbug.entities.IssueType;
import com.snapbug.mappers.IssueTypeMapper;
import com.snapbug.repositories.IIssueTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IssueTypeService implements IIssueTypeService {

  private final IIssueTypeRepository issueTypeRepository;
  private final IssueTypeMapper issueTypeMapper;

  @Autowired
  public IssueTypeService(IIssueTypeRepository issueTypeRepository, IssueTypeMapper issueTypeMapper) {
    this.issueTypeRepository = issueTypeRepository;
    this.issueTypeMapper = issueTypeMapper;
  }

  @Override
  public IssueTypeDTO save(IssueTypeCreationDTO issueType) {
    final IssueType model = issueTypeRepository.save(issueTypeMapper.dtoToModel(issueType));
    return issueTypeMapper.modelToDto(model);
  }

  @Override
  public List<IssueTypeDTO> getAll() {
    return issueTypeRepository
            .findAll()
            .stream()
            .map(issueTypeMapper::modelToDto)
            .toList();
  }

  @Override
  public void delete(Long issueTypeId) {
    issueTypeRepository.deleteById(issueTypeId);
  }

  @Override
  public IssueTypeDTO update(IssueTypeDTO issueType) {
    final IssueType model = issueTypeRepository.save(issueTypeMapper.dtoToModel(issueType));
    return issueTypeMapper.modelToDto(model);
  }
}
