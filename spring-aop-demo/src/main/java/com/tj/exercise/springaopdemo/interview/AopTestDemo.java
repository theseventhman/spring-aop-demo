package com.tj.exercise.springaopdemo.interview;

import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2023/2/5 15:33
 */

public class AopTestDemo {
    public String method(String methodName){
        return "调用的方法为"+methodName;
    }
}
