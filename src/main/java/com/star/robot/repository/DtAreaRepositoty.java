package com.star.robot.repository;

import com.star.robot.entity.DtArea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DtAreaRepositoty extends CrudRepository<DtArea, Long> {

    public List<DtArea> findAllByAreaParentId(Long parentId);

}
