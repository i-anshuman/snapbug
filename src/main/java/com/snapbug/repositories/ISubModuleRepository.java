package com.snapbug.repositories;

import com.snapbug.entities.Module;
import com.snapbug.entities.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubModuleRepository extends JpaRepository<SubModule, Long> {
  List<SubModule> findByModule(Module module);
}
