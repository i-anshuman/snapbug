package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_modules")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SubModule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sub_module_id")
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne
  @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false)
  private Module module;
}
