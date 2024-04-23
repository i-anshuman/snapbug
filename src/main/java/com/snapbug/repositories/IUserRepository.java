package com.snapbug.repositories;

import com.snapbug.dtos.UserListDTO;
import com.snapbug.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
  List<UserListDTO> getAll();
}
