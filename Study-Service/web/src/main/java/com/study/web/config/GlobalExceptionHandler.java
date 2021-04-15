package com.study.web.config;

import com.study.bean.enums.ResponseEnum;
import com.study.bean.exception.ApiException;
import com.study.bean.response.ResultBody;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResultBody apiExceptionHandler(HttpServletRequest req, ApiException e){
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getMessage());
    }

    /**
     * 处理空指针异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是：{}", e);
        return ResultBody.error(ResponseEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是：{}", e);
        return ResultBody.error(ResponseEnum.INTERAL_SERVER_ERROR);
    }
}