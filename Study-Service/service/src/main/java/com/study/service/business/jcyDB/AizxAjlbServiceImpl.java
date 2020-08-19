package com.study.service.business.jcyDB;

import com.study.bean.entity.AizxAjlb;
import com.study.dal.mapper.AizxAjlbMapper;
import com.study.service.api.jcyDB.AizxAjlbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 16:23
 * @description：TODO
 */
@Service
public class AizxAjlbServiceImpl implements AizxAjlbService {

    @Resource
    private AizxAjlbMapper aizxAjlbMapper;
    
    @Override
    public AizxAjlb getOne() {
        return aizxAjlbMapper.selectByPrimaryKey(3);
    }
}
