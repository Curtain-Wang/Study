package com.study.dal.mapper;

import com.study.bean.entity.SysAccount;
import com.study.core.base.dal.BaseMapper;

public interface SysAccountMapper extends BaseMapper<SysAccount> {

    SysAccount getAll();
}