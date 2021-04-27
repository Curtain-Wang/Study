package com.study.service.business.db01;

import com.study.bean.dto.AddPersonParam;
import com.study.bean.entity.Person;
import com.study.bean.response.ResultBody;
import com.study.core.convert.PersonConvert;
import com.study.dal.mapper.PersonMapper;
import com.study.service.api.db01.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Curtain
 * @Date 2021/4/26 15:52
 * @Description
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public Integer add(AddPersonParam addPersonParam) {
        Person person = PersonConvert.INSTANCE.fromDTO(addPersonParam);
        personMapper.insertSelective(person);
        return person.getId();
    }
}
