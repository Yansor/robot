package com.star.robot.repository;

import com.star.robot.entity.Project;
import com.star.robot.entity.ProjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends JpaRepository<Project, Long> {


}
