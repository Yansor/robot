package com.star.robot.controller;

import com.star.robot.dto.CommonRequestDto;
import com.star.robot.dto.CompanyRequestDto;
import com.star.robot.dto.ResultDto;
import com.star.robot.entity.Company;
import com.star.robot.repository.CompanyRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @ApiOperation(value = "后台单位查询")
    @GetMapping(value = "/")
    public ResultDto getAll(CompanyRequestDto requestDto){
        List<Company> companies = companyRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {

                //总条件
                List<Predicate> conditions = new ArrayList<>();

                if(requestDto.getAreaId()!=null){
                    //所在地区
                    Predicate areaCondition = cb.equal(root.get("areaId") ,requestDto.getAreaId());
                    conditions.add(areaCondition);
                }
                if(!StringUtils.isEmpty(requestDto.getZhiZhao())){
                    //单位名称
                    Predicate nameCondition = cb.like(root.get("zhiZhao") , "%"+requestDto.getZhiZhao()+"%");
                    conditions.add(nameCondition);
                }
                if(requestDto.getCompanyType() != null){
                    //机构　还是　学校
                    Predicate typeCondition = cb.equal(root.get("companyType") , requestDto.getCompanyType());
                    conditions.add(typeCondition);
                }

                Predicate[] pre = new Predicate[conditions.size()];

                cq.where(conditions.toArray(pre));
                return cq.getRestriction();
            }
        });
        return ResultDto.builder().data(companies).build();
    }

    @ApiOperation(value = "后台单位学校删除")
    @DeleteMapping(value = "/")
    public ResultDto delete(@RequestBody CommonRequestDto requestDto){
        if(requestDto == null || requestDto.getId() == null){
            throw new IllegalArgumentException("删除单位ID必须");
        }
        companyRepository.deleteById(requestDto.getId());
        return ResultDto.builder().data(null).build();

    }

    @ApiOperation(value = "后台单位新增")
    @PostMapping("/")
    public ResultDto add(@RequestBody  CompanyRequestDto requestDto){
        if(requestDto == null || requestDto.getId() != null){
            throw new IllegalArgumentException("单位新增无需填写ID");
        }

        Company company = new Company();
        company.setCreateTime(new Date());
        company.setUpdateTime(new Date());
        BeanUtils.copyProperties(requestDto , company);
        companyRepository.save(company);
        return ResultDto.builder().data(null).build();

    }

    @ApiOperation(value = "单位修改")
    @PutMapping("/")
    public ResultDto update(@RequestBody  CompanyRequestDto requestDto){
        validateRequestParam(requestDto);

        Company oldCompany = companyRepository.findById(requestDto.getId()).get();
        Company company = new Company();
        company.setUpdateTime(new Date());
        //保留上一次的创建时间
        company.setCreateTime(oldCompany.getCreateTime());
        BeanUtils.copyProperties(requestDto , company);

        //后台
        if(requestDto.getRequestSource() == 1){
            companyRepository.save(company);
        }else if(requestDto.getRequestSource() == 2){
            //前台请求　更改发票税号　发票抬头
            oldCompany.setInvoiceHeader(requestDto.getInvoiceHeader());
            oldCompany.setInvoiceTaxNo(requestDto.getInvoiceTaxNo());
            companyRepository.save(oldCompany);
        }

        return ResultDto.builder().build();
    }

    private void validateRequestParam(CompanyRequestDto requestDto) {

        if(requestDto.getRequestSource() == null){
            throw new IllegalArgumentException("单位修改请求来源必填,1 后台, 2 前台");
        }

        if(requestDto.getId() == null){
            throw new IllegalArgumentException("单位修改ID必填");
        }

        if(requestDto.getRequestSource() == 1){

        }else if(requestDto.getRequestSource() == 2){
            if(StringUtils.isEmpty(requestDto.getInvoiceHeader())  && StringUtils.isEmpty(requestDto.getInvoiceTaxNo())){
                throw new IllegalArgumentException("发票抬头,发票税号必填其一");
            }
        }else{
            throw new IllegalArgumentException("单位修改请求来源非法");
        }

        //是否存在
        Company oldCompany = companyRepository.findById(requestDto.getId()).get();

        if(oldCompany == null){
            throw new IllegalArgumentException("单位更新失败,给定ID:"+requestDto.getId()+"记录不存在");
        }
    }

}
