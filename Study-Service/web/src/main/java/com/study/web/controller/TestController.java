package com.study.web.controller;

import com.study.bean.exception.ApiException;
import com.study.core.utils.DateUtil;
import com.study.web.config.schedule.Executable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:41
 * @Description
 */
@RestController
@Api(value = "TestController", tags = {"测试接口"})
public class TestController {

    @Resource
    Executable executable;

    @GetMapping("apiexception")
    @ApiOperation(value = "apiException", notes = "定义异常捕获测试")
    public boolean apiException(){
        if (true)
            throw  new ApiException("-1", "自定义异常");
        return true;
    }

    @GetMapping("nullpointexception")
    @ApiOperation(value = "nullpointexception", notes = "空指针异常捕获测试")
    public boolean nullPointException(){
        String s = null;
        s.equals("123");
        return true;
    }

    @GetMapping("numberformatexception")
    @ApiOperation(value = "numberformatexception", notes = "强转类型异常捕获测试")
    public boolean numberFormatException(){
        String s = "qwe123";
        Integer.parseInt(s);
        return true;
    }

    @GetMapping("/schedule")
    @ApiOperation(value = "schedule", notes = "定时执行测试")
    public boolean schedule() throws ParseException {
        String date = "2021-04-19 17:00:50";
        executable.runOnceSchedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务启动啦~~");
            }
        }, DateUtil.parseDate(date, "yyyy-MM-dd HH:mm:ss"));
        return true;
    }
}
