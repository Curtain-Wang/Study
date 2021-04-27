package com.study.web.config;

import com.study.bean.enums.ResponseEnum;
import com.study.bean.exception.ApiException;
import com.study.bean.response.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintDefinitionException;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ApiException.class)
    public ResultBody apiExceptionHandler(ApiException e){
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(NullPointerException e){
        logger.error("发生空指针异常");
        return ResultBody.error(ResponseEnum.BODY_NOT_MATCH);
    }

    /**
     * 捕获全局入参错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultBody handleConstraintViolationException(ConstraintViolationException e){
        return ResultBody.error(e.getConstraintViolations().stream().map(d -> d.getMessageTemplate()).collect(Collectors.joining(",")));
    }

    /**
     * 捕获全局入参错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody handleGlobalException(MethodArgumentNotValidException e){
        return ResultBody.error(e.getBindingResult().getAllErrors().stream().map(a -> a.getDefaultMessage()).collect(Collectors.joining(",")));
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e){
        logger.error("未知异常！原因是：{}", e);
        return ResultBody.error(ResponseEnum.INTERAL_SERVER_ERROR);
    }
}