package com.study.web.controller;

import com.study.core.base.bean.ResponseResult;
import com.study.service.api.jcyDB.AizxAjlbService;
import com.study.service.api.xtglDB.SysAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 12:00
 * @description：多数据源Controller
 */
@RestController
@RequestMapping("/dsjy")
@Api(value = "dsjy", tags = {"多数据源"})
public class DsjyController {

    @Resource
    private SysAccountService sysAccountService;
    @Resource
    private AizxAjlbService aizxAjlbService;

    /**
     * 多数据源测试
     * @return
     */
    @GetMapping("/first")
    @ApiOperation(value = "first", notes = "多数据源第一次测试")
    public ResponseResult first(){
        Map map = new HashMap();
        map.put("aizx", aizxAjlbService.getOne());
        map.put("xtgl", sysAccountService.getOne());
        return new ResponseResult(map);
    }
}
