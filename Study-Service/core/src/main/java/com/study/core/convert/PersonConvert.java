package com.study.core.convert;


import com.study.bean.dto.AddPersonParam;
import com.study.bean.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Curtain
 * @Date 2021/4/26 16:13
 * @Description
 */
@Mapper
public interface PersonConvert {
    PersonConvert INSTANCE = Mappers.getMapper(PersonConvert.class);

    Person fromDTO(AddPersonParam addPersonParam);
}
