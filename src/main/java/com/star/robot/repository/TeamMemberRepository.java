package com.star.robot.repository;

import com.star.robot.entity.Team;
import com.star.robot.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeamMemberRepository extends JpaSpecificationExecutor, JpaRepository<TeamMember,Long> {


}
