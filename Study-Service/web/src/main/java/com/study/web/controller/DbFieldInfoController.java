package com.study.web.controller;

import com.study.bean.request.dbField.DbFieldInfoRequest;
import com.study.core.annotation.PermissionsAnnotation;
import com.study.core.base.bean.ResponseResult;
import com.study.service.api.oraDB.DbFieldInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/5 15:59
 * @description：TODO
 */
@RestController
@RequestMapping("/dbField")
@Api(value = "dbField", tags = {"数据库字段"})
public class DbFieldInfoController {

    @Resource
    private DbFieldInfoService dbFieldInfoService;

    @PostMapping("/getMostFieldInfo")
    @ApiOperation(value = "getMostFieldInfo", notes = "获取高相似度的字段信息")
    @PermissionsAnnotation()
    public ResponseResult getMostFieldInfo(@Valid DbFieldInfoRequest dbFieldInfoRequest){
        return dbFieldInfoService.getMostFieldInfo(dbFieldInfoRequest.getComments());
    }
}
