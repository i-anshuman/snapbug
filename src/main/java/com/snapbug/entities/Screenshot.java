package com.snapbug.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Table(name = "screenshots")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Screenshot {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "screenshot_id")
  private Long id;

  @Column(nullable = false)
  private String filepath;

  @Column(name = "added_on", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime addedOn;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private User user;
}
