package com.study.bean.request.dbField;

import com.study.core.base.bean.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/5 16:10
 * @description：TODO
 */
public class DbFieldInfoRequest extends BaseRequest {

    @ApiModelProperty(value = "字段注释",name = "comments")
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
