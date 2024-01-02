package com.networkdesign.industrialnetworksystem.exception;

import com.networkdesign.industrialnetworksystem.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException ex) {
        return Result.error(ex.getCode(), ex.getMessage());
    }
}
