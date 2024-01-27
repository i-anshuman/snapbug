package com.snapbug.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actions")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Action {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "action_id")
  private Long id;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String cause;

  @Column(name = "acted_on", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime actedOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "acted_by", nullable = false)
  private User actor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "issue_id", nullable = false)
  private Issue issue;

  @OneToMany
  @JoinTable(
    name = "action_screenshot",
    joinColumns = @JoinColumn(name = "action_id"),
    inverseJoinColumns = @JoinColumn(name = "screenshot_id")
  )
  private List<Screenshot> screenshots;
}
