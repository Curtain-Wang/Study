package com.study.bean.volidate;

import com.study.bean.dto.AddPersonParam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author Curtain
 * @Date 2021/4/26 15:41
 * @Description
 */
public class AgeAdultValidator implements ConstraintValidator<AgeAdultCompare, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof AddPersonParam){
            AddPersonParam param = (AddPersonParam) o;
            if (param.getAge() != null && param.getAdult() != null){
                if (param.getAge() > 17 && param.getAdult() == 0)
                    return false;
                if (param.getAge() < 17 && param.getAdult() == 1)
                    return false;
            }
        }
        return true;
    }

}
