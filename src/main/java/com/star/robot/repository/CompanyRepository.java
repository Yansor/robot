package com.star.robot.repository;

import com.star.robot.entity.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends  JpaSpecificationExecutor,CrudRepository<Company,Long> {
}
