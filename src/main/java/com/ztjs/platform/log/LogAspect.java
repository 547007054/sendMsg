package com.ztjs.platform.log;

import com.ztjs.platform.common.spring.SpringContextHolder;
import com.ztjs.platform.model.po.log.OperationLogPo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:22
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.ztjs.platform.log.Logger)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Logger loggerAnnotation = method.getAnnotation(Logger.class);

        OperationLogPo logPo = LogUtils.getOperationLog();
        logPo.setClassName(className);
        logPo.setMethodName(methodName);
        logPo.setMessage(loggerAnnotation.description());

        Long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = point.proceed();
            logPo.setSucceed(1);
        } catch (Throwable throwable) {
            logPo.setSucceed(-1);
            throwable.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        logPo.setTime(endTime - startTime);
        SpringContextHolder.publishEvent(new LogEvent(this, logPo));
        return obj;
    }

}