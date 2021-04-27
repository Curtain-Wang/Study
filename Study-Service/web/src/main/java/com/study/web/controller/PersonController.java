package com.study.web.controller;

import com.study.bean.dto.AddPersonParam;
import com.study.bean.response.ResultBody;
import com.study.service.api.db01.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author Curtain
 * @Date 2021/4/26 15:49
 * @Description
 */
@RestController
@RequestMapping("/api/v1")
@Api(tags = "人员控制类")
public class PersonController {

    @Resource
    private PersonService personService;

    @PostMapping("/person")
    @ApiOperation(value = "新增人员", notes = "新增人员")
    ResultBody addPerson(@RequestBody @Valid AddPersonParam addPersonParam){
        return ResultBody.success(personService.add(addPersonParam));
    }
}
