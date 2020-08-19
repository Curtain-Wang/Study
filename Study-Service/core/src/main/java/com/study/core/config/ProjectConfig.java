package com.study.core.config;

import com.study.core.base.dal.BaseMapper;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/16 9:58
 * @description：TODO
 */
public class ProjectConfig {

    public static String BASE_MAPPER = BaseMapper.class.getName();

    public static String MAPPER_PACKAGE = "com.study.dal.mapper";

    public static String TYPE_HANDLERS_PACKAGE = "com.study.**.dal.typehandler";

    public static String MODEL_PACKAGE = "com.study.bean.entity";

    public static String MAPPING_PACKAGE = "classpath*:/com/**/dal/mapping/**/*.xml";
}
