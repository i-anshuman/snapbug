package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "screens")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Screen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "screen_id")
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne
  @JoinColumn(name = "sub_module_id", referencedColumnName = "sub_module_id", nullable = false)
  private SubModule subModule;
}
