package com.star.robot.repository;


import com.star.robot.entity.TeamClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectClassRepository extends CrudRepository<TeamClass, Long> {

    public List<TeamClass> findByParentId(Long parentId);
}
