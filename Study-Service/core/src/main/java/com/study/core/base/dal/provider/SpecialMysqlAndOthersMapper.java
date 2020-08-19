package com.study.core.base.dal.provider;

import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

public interface SpecialMysqlAndOthersMapper<T> {
    @InsertProvider(
            type = SpecialMysqlAndOthersProvider.class,
            method = "dynamicSQL"
    )
    int insertMysqlAndOthersList(List<T> var1);
}
