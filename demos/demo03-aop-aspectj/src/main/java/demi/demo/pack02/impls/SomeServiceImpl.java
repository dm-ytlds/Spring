package demi.demo.pack02.impls;

import demi.demo.pack02.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 给doSome()方法增加一些功能，在doSome()方法执行之前，输出方法的执行时间
        System.out.println("执行目标方法doSome()");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("执行目标方法doOther()");
        return "QAQ";
    }


}
