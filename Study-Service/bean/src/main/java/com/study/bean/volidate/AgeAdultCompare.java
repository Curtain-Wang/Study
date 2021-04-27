package com.study.bean.volidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author Curtain
 * @Date 2021/4/26 15:40
 * @Description 自定义注解，校验年龄和是否成年
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = AgeAdultValidator.class)
public @interface AgeAdultCompare {
    //校验未通过时的返回信息
    String message() default "年龄和是否成年要相对应";

    //以下两行未固定模板
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
