package com.snapbug.repositories;

import com.snapbug.entities.Screenshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScreenshotRepository extends JpaRepository<Screenshot, Long> {
}
