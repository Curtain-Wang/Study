package com.study.web.controller;

import com.study.service.api.db01.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController()
@Api(value = "DeptController", tags = {"部门控制类"})
@RequestMapping("/test")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping(value = "/export", headers="Accept=application/octet-stream")
    @ApiOperation(value = "export", notes = "导出部门列表")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = "部门.xls";
        //在服务器上创建一个exportexcel文件夹(如果这个exportexcel文件夹不存在的话)
        String dirpath = request.getSession().getServletContext().getRealPath("/") + "exportexcel";
        File dir = new File(dirpath);
        if(!dir.exists())
            dir.mkdirs();//如果目标文件夹不存在则创建新的文件夹
        String fileuri = dirpath + File.separator + filename;
        deptService.export(fileuri);

//        String name = new String("信息.xls".getBytes("UTF-8"), "ISO-8859-1");
        String name = "info.xls";
        response.setHeader("Content-Disposition", "attachment:filename=" + name);
        InputStream in = new FileInputStream(new File(fileuri));
        OutputStream out = response.getOutputStream();
        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }
        in.close();
        out.close();
    }

    @PostMapping("/upload")
    @ApiOperation(value = "upload", notes = "上传部门列表")
    public void upload(MultipartFile file) throws Exception {
        deptService.upload(file);
    }
}
