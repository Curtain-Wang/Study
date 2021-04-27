package com.study.bean.dto;

import com.study.bean.volidate.AgeAdultCompare;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Curtain
 * @Date 2021/4/26 15:34
 * @Description
 */
@Data
@ApiModel("新增用户请求体")
@AgeAdultCompare
public class AddPersonParam {

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(name = "name", value = "姓名", required = true)
    private String name;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    @ApiModelProperty(name = "sex", value = "性别", required = true)
    private String sex;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄最小为10岁")
    @Max(value = 1000, message = "人类目前年龄超不过1000岁")
    @ApiModelProperty(name = "age", value = "年龄", required = true)
    private Integer age;

    /**
     * 0未成年1成年
     */
    @NotNull(message = "是否成年不能为空")
    @ApiModelProperty(name = "adult", value = "0未成年1成年", required = true)
    private Integer adult;
}
