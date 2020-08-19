package com.study.service.business.xtglDB;

import com.study.bean.entity.SysAccount;
import com.study.dal.mapper.SysAccountMapper;
import com.study.service.api.xtglDB.SysAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 16:27
 * @description：TODO
 */
@Service
public class SysAccountServiceImpl implements SysAccountService {

    @Resource
    private SysAccountMapper sysAccountMapper;

    @Override
    public SysAccount getOne() {
        return sysAccountMapper.getAll();
    }
}
