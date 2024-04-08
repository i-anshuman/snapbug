package com.snapbug.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Long id;

  @Column(name = "role_name", length = 10, nullable = false, unique = true)
  private String name;

  @ManyToMany
  @JoinTable(
    name = "role_permission",
    joinColumns = @JoinColumn(name = "role_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "permission_id", nullable = false)
  )
  private Set<Permission> permissions;
}
