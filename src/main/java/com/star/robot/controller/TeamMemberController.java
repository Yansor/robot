package com.star.robot.controller;

import com.star.robot.dto.PageResultDto;
import com.star.robot.dto.TeamMemberQueryDto;
import com.star.robot.entity.Team;
import com.star.robot.entity.TeamMember;
import com.star.robot.enums.CompanyTypeEnum;
import com.star.robot.enums.TeamGroupTypeEnum;
import com.star.robot.repository.TeamMemberRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/team/member")
public class TeamMemberController {


    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @GetMapping(value = "/")
    @ApiOperation(value = "队员查询",notes = "队员查询")
    public PageResultDto get(TeamMemberQueryDto requestDto){
        PageResultDto<TeamMember> results = new PageResultDto<>();
        if(requestDto.getPage() != null && requestDto.getLimit() != null) {
            //后端框架分页从0开始 前端框架从1开始
            if (requestDto.getPage() >= 1) {
                requestDto.setPage(requestDto.getPage() - 1);
            }
            Pageable page = new PageRequest(requestDto.getPage(), requestDto.getLimit());

            Page<TeamMember> pageable = teamMemberRepository.findAll(new Specification() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                    List<Predicate> conditions = new ArrayList<>();

                    //省
                    if(requestDto.getProvinceId() != null){
                        Predicate provinceCondition = cb.equal(root.get("team").get("provinceId")  , requestDto.getProvinceId());
                        conditions.add(provinceCondition);
                    }
                    //市
                    if(requestDto.getCityId() != null){
                        Predicate cityCondition = cb.equal(root.get("team").get("cityId")  , requestDto.getCityId());
                        conditions.add(cityCondition);
                    }
                    //区
                    if(requestDto.getAreaId() != null){
                        Predicate areaCondition = cb.equal(root.get("team").get("areaId")  , requestDto.getAreaId());
                        conditions.add(areaCondition);
                    }
                    //队员姓名
                    if(!StringUtils.isEmpty(requestDto.getTeamMemberName())){
                        Predicate memberNameCond = cb.like(root.get("name")  , "%"+requestDto.getTeamMemberName()+"%");
                        conditions.add(memberNameCond);
                    }
                    //队员身份证
                    if(!StringUtils.isEmpty(requestDto.getTeamMemberIdCard())){
                        Predicate memberIdCardCond = cb.like(root.get("idCard")  , "%"+requestDto.getTeamMemberName()+"%");
                        conditions.add(memberIdCardCond);
                    }
                    //单位名称
                    if(requestDto.getCompanyId() != null){
                        Predicate companyCond = cb.equal(root.get("team").get("companyId") , requestDto.getCompanyId());
                        conditions.add(companyCond);
                    }
                    //队伍名称
                    if(!StringUtils.isEmpty(requestDto.getTeamName())){
                        Predicate teamNameCond = cb.like(root.get("team").get("teamName") , "%"+requestDto.getTeamName()+"%");
                        conditions.add(teamNameCond);
                    }
                    //单位性质
                    if(requestDto.getCompanyType() !=null){
                        CompanyTypeEnum companyType = null;
                        if(requestDto.getCompanyType().intValue() == 1){
                            companyType =  CompanyTypeEnum.GONGSI;
                        }else if(requestDto.getCompanyType().intValue() == 1){
                            companyType =  CompanyTypeEnum.JIGOU;
                        }else{
                            //默认公司
                            companyType =  CompanyTypeEnum.GONGSI;
                        }
                        Predicate companyTypeCond = cb.equal(root.get("team").get("companyType") ,companyType);
                        conditions.add(companyTypeCond);

                    }
                    //成绩 TODO 业务待确认

                    //报名时间 => 队伍　新增时间
                    if(!StringUtils.isEmpty(requestDto.getBaoMingDateStart())
                            && !StringUtils.isEmpty(requestDto.getBaoMingDateEnd())){
                        Predicate baoMingDateCond = cb.between(root.get("team").get("createTime") ,requestDto.getBaoMingDateStart() , requestDto.getBaoMingDateEnd());
                        conditions.add(baoMingDateCond);
                    }
                    //参赛类别
                    //大类
                    if(requestDto.getClass1Id() != null){
                        Predicate class1IdCond = cb.equal(root.get("team").get("class1Id") ,requestDto.getClass1Id());
                        conditions.add(class1IdCond);
                    }
                    //小类
                    if(requestDto.getClass2Id() != null){
                        Predicate class2IdCond = cb.equal(root.get("team").get("class2Id") ,requestDto.getClass2Id());
                        conditions.add(class2IdCond);
                    }
                    //组别
                    if(requestDto.getGroupType() != null){
                        TeamGroupTypeEnum groupTypeEnum = null;
                        if(requestDto.getGroupType() == 1){
                            groupTypeEnum = TeamGroupTypeEnum.XIAOXUE;
                        }else if(requestDto.getGroupType() == 2){
                            groupTypeEnum = TeamGroupTypeEnum.ZHONGXUE;
                        }else if(requestDto.getGroupType() == 3){
                            groupTypeEnum = TeamGroupTypeEnum.DAXUE;
                        }else{
                            //默认小学组
                            groupTypeEnum = TeamGroupTypeEnum.XIAOXUE;
                        }
                        Predicate groupTypeCond = cb.equal(root.get("team").get("groupType") ,groupTypeEnum);
                        conditions.add(groupTypeCond);
                    }
                    if(requestDto.getSizeEnum() != null){
                        Predicate sizeCond = cb.equal(root.get("size") ,requestDto.getSizeEnum());
                        conditions.add(sizeCond);
                    }

                    Predicate[] pre = new Predicate[conditions.size()];

                    cq.where(conditions.toArray(pre));
                    return cq.getRestriction();
                }
            } , page);

            results.setCount(pageable.getTotalElements());
            results.setData(pageable.getContent());

            return results;
        }
        return PageResultDto.builder().data(null).build();
    }
}
