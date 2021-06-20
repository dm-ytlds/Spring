package demi.demo.pack03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * 给doSome()方法加功能，用单独创建的切面类来实现。
 *
 */

@Aspect
public class MyAspect {

    @Around(value = "execution(* demi.demo.pack03.impls.SomeServiceImpl.around(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        String name = "";
        Object[] args = pjp.getArgs();
        if(args != null && args.length > 1) {
            Object arg = args[0];
            name = (String)arg;
        }

        // 实现环绕通知
        Object res = null;
        System.out.println("环绕通知：在目标方法之前，执行时间：" + new Date());
        // 目标方法的调用
        if("ls".equals(name)) {
            res = pjp.proceed();
        }
        System.out.println("环绕通知：在目标方法之后，执行时间：" + new Date());

        // 返回目标方法的执行结果
        return res;
    }

}
