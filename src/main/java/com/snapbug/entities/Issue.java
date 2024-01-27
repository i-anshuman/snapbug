package com.snapbug.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Entity
@Table(name = "issues")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Issue {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "issue_id")
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String expectation;

  @Column(name = "module_name", length = 50, nullable = false)
  private String moduleName;

  @Column(name = "submodule_name", length = 50, nullable = false)
  private String submoduleName;

  @Column(name = "screen_name", length = 50, nullable = false)
  private String screenName;

  @Column(name = "reported_on", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime reportedOn;

  @ManyToOne
  @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
  private Status status;

  @ManyToOne
  @JoinColumn(name = "issue_type", referencedColumnName = "issue_type_id", nullable = false)
  private IssueType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reported_by", referencedColumnName = "user_id", nullable = false)
  private User reportedBy;

  @OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)
  private List<Action> actions;

  @OneToMany
  @JoinTable(
    name = "issue_screenshot",
    joinColumns = @JoinColumn(name = "issue_id"),
    inverseJoinColumns = @JoinColumn(name = "screenshot_id")
  )
  private List<Screenshot> screenshots;
}
