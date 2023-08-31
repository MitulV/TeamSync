package com.project.TeamSync.Repository;

import com.project.TeamSync.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project ,Long> {
}
