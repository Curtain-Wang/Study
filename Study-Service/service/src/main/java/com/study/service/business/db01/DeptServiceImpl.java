package com.study.service.business.db01;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.study.bean.entity.Dept;
import com.study.dal.mapper.DeptMapper;
import com.study.service.api.db01.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public void export(String url) {
        List<Dept> list = deptMapper.selectAll();
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(url);
        //自定义标题别名
        writer.addHeaderAlias("deptno", "部门编号");
        writer.addHeaderAlias("dname", "部门名称");
        writer.addHeaderAlias("dbSource", "来源数据库");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        // 关闭writer，释放内存
        writer.close();
    }
}
