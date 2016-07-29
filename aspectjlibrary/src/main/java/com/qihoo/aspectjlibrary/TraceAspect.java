package com.qihoo.aspectjlibrary;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.ConstructorSignature;

/**
 * Created by zhangying-pd on 2016/6/28.
 *
 * Aspect representing the cross cutting-concern: Method and Constructor Tracing.
 */
@Aspect
public class TraceAspect {
    private static final String DEBUG_POINTCUT_METHOD =
            "execution(@com.qihoo.aspectjlibrary.DebugTrace * *(..))";

    private static final String DEBUG_POINTCUT_CONSTRUCTOR =
            "execution(@com.qihoo.aspectjlibrary.DebugTrace *.new(..))";

    @Pointcut(DEBUG_POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {}

    @Pointcut(DEBUG_POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {}

    @Pointcut("execution(com.qihoo.aspectjsample.MainActivity.new(..))")
    public void constructorTrack(){}

//    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    @Around("constructorTrack()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ConstructorSignature methodSignature = (ConstructorSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        DebugLog.log(className, buildLogMessage(methodName, stopWatch.getTotalTimeMillis()));

        return result;
    }

    /**
     * Create a log message.
     *
     * @param methodName A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    private static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append("TraceAspect --> ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }
}
