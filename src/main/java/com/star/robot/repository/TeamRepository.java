package com.star.robot.repository;

import com.star.robot.entity.Company;
import com.star.robot.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends JpaSpecificationExecutor, JpaRepository<Team,Long> {


}
