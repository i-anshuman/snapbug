package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "issue_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "issue_type_id")
  private Long id;

  @Column(name = "issue_type_name", length = 15, nullable = false, unique = true)
  private String name;
}
