package com.star.robot.repository;


import com.star.robot.entity.DtArea;
import com.star.robot.entity.ProjectClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectClassRepository extends CrudRepository<ProjectClass, Long> {

    public List<ProjectClass> findByParentId(Long parentId);
}
