package demi.demo.pack02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * 给doSome()方法加功能，用单独创建的切面类来实现。
 *
 */

@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     *      公共方法 public
     *      方法没有返回值 void
     *      方法名称自定义
     *      方法可以有参数，也可以没有参数
     *          如果有参数，参数不是自定义的，有几个参数类型可以使用。
     *
     * @Before ：前置通知注解
     *      属性：value，是切入点表达式，表示切面的功能执行位置。
     *      位置：在方法的上面。
     * 特点：
     *      1.在目标方法之前先执行
     *      2.不会改变目标方法的执行结果
     *      3.不会影响目标方法的执行。
     */
    // 切入点表达式是可以简写的
    // 原始写法：@Before(value = "execution(public void demi.demo.pack01.impls.SomeServiceImpl.doSome(String, Integer))")
    /*
        简写要求：
        public 修饰符是可以省略不写的
            第一个*：表示可以返回所有可行的数据类型
            第二个*：*表示包名的名称不限
            第三个*：表示匹配以do开头的所有方法
            ..：表示可以接任意形参类型
     */
    @Before(value = "execution(* *..SomeServiceImpl.doSome(..))")
    public void myBefore() {
        // 切面类要执行的功能代码
        System.out.println("前置通知(Before)。在目标方法之前输出执行时间：" + new Date());
    }

    /**
     * 后置通知必须有返回值。
     * 返回值类型最好是Object。
     * 在@AfterReturning 的参数中 returning 的 值和myAfter()方法的返回值是一样的。
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfter(Object res) {
        // 切面类要执行的功能代码
        System.out.println("后置通知(AfterReturning)。在目标方法之后输出执行时间：" + new Date() + "：" + res);
    }
}
