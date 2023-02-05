package com.tj.exercise.springaopdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.tj.exercise.springaopdemo.dto.AopDemoDto;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@Aspect
@Configuration
public class RequestParamAspect {
	
	@Pointcut("execution(public * com.tj.exercise.springaopdemo.controller.AopDemoController.*(..))")
	public void changeParam() {
		
	}
	
	@Around(value="changeParam()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Object[] args = proceedingJoinPoint.getArgs();
		if(args.length >=1) { 
		Object resultObject = ChangeValueByTypeUtil(proceedingJoinPoint,args);
		return resultObject;
		}
		return null;
	}
 
	/**
	 * 修改request请求传递过来的参数
	 * @param proceedingJoinPoint
	 * @param args 参数
	 * @return
	 * @throws Throwable
	 */
	private Object ChangeValueByTypeUtil(ProceedingJoinPoint proceedingJoinPoint, Object[] args)throws Throwable {
		Object result = new Object();
		Object arg = args[0];
		JSONObject jsonObject = JSONUtil.parseObj(arg);
		if(jsonObject.get("title")!=null) {
		jsonObject.set("title", "change");
		args[0] = jsonObject.toBean(arg.getClass());
		
		}
		result = proceedingJoinPoint.proceed(args);
		return result;
		
	}
	
	private Object ChangeValueByType(ProceedingJoinPoint proceedingJoinPoint, Object[] args)throws Throwable {
		Object result = new Object();
		Object arg = args[0];
		JSONObject jsonObject = JSONUtil.parseObj(arg);
		if(jsonObject.get("title")!=null) {
		jsonObject.set("title", "change");
		if(arg instanceof AopDemoDto) {
		args[0] = JSONUtil.toBean(jsonObject, arg.getClass());
		}
		}
		result = proceedingJoinPoint.proceed(args);
		return result;
		
	}

}
