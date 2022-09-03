package com.reggie.comon;

/**
 * 类描述：
 *      自定义业务异常
 * @ClassName CustomException
 * @Description TODO
 * @Author Ming
 * @Date 2022/7/22 11:04
 * @Version 1.0
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
