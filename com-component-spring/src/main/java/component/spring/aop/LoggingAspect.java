package component.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/24.
 */
//类声明为切面:放入IOC，再声明为切面
@Aspect
@Component
public class LoggingAspect {

    //前置通知
    @Before("execution(* component.spring.aop.ArithmeticCalculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("method before ....."+args);
    }

    //不能访问返回执行结果
    @After("execution(* component.spring.aop.ArithmeticCalculator.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("method end ....."+methodName);
    }

    //正常结束后执行  可以访问方法返回值
    @AfterReturning(value = "execution(* component.spring.aop.ArithmeticCalculator.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){

        String methodName = joinPoint.getSignature().getName();
        System.out.println("method return end ....."+result);
    }

    //异常结束后执行
    @AfterThrowing(value = "execution(* component.spring.aop.ArithmeticCalculator.*(..))",throwing = "ex")
    public void AfterThrowing(JoinPoint joinPoint,Exception ex){//可以指定异常   如NullException  只有出现这个异常才会执行

        String methodName = joinPoint.getSignature().getName();
        System.out.println("method return end ....."+ex.getMessage());
    }

    //环绕通知  携带参数ProceedingJoinPoint
    //类似于动态代理的全过程 ProceedingJoinPoint可以决定是否执行目标方法
    //且必须有返回值,返回值即为目标方法的返回值
    @Around(value = "execution(* component.spring.aop.ArithmeticCalculator.*(..))")
    public Object around(ProceedingJoinPoint pj){

        Object object = null;
        try {
            System.out.println("around ...");
            object = pj.proceed();//执行目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}
