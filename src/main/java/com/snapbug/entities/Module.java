package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modules")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Module {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "module_id")
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;
}
