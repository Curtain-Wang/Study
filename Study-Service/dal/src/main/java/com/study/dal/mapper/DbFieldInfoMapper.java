package com.study.dal.mapper;

import com.study.bean.entity.DbFieldInfo;
import com.study.core.base.dal.BaseMapper;

import java.util.List;
import java.util.Map;

public interface DbFieldInfoMapper extends BaseMapper<DbFieldInfo> {

    List<Map<String, String>> getAllFieldInfo();
}
