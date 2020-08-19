package com.study.core.base.dal;

import com.study.core.base.dal.provider.SpecialMysqlAndOthersMapper;
import tk.mybatis.mapper.common.ConditionMapper;

public interface BaseMapper<T> extends tk.mybatis.mapper.common.Mapper<T>
        , ConditionMapper<T>,
        SpecialMysqlAndOthersMapper<T> {
}
