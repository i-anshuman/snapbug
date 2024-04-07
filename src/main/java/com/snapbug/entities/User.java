package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 50, nullable = false, unique = true)
  private String email;

  @Column(length = 50, nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(name = "join_date", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime joinDate;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
  private Role role;
}
