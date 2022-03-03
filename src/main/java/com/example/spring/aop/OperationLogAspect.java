package com.example.spring.aop;

import com.example.spring.entity.Log;
import com.example.spring.repository.LogRepository;
import com.example.spring.sse.SseEmitterServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class OperationLogAspect {

  private static final Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

  @Autowired
  private LogRepository logRepository;

  @Around(value = "@annotation(log)")
  private Object recordOperationLog(ProceedingJoinPoint joinPoint, OperationLog log) throws Throwable {

    // 获取用户操作信息
    long timestamp = System.currentTimeMillis();
//    logger.info("timestamp: " + timestamp);
    HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    String remoteIp = request.getRemoteAddr();
//    logger.info("user IP: " + remoteIp);
    Signature signature = joinPoint.getSignature();
    String operation = signature.toString();
//    logger.info("operation: " + signature);
    Object[] args = joinPoint.getArgs();
    String arguments = Arrays.toString(args);
//    logger.info("arguments: " + arguments);
    String description = log.description();
//    logger.info("description: " + description);

    // 执行用户操作
    Object returnedValue = joinPoint.proceed();

    // 记录操作日志并写入数据库
    Log opLog = new Log(remoteIp, operation, arguments, description, timestamp);
    Log save = logRepository.save(opLog);
    logger.info("log: " + save);
    SseEmitterServer.batchSendMessage(opLog.toString());
//    logger.info("batchSendMessage: " + opLog);
    logger.info("returned value: " + returnedValue);

    return returnedValue;
  }

}
