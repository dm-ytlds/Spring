package demi.demo.pack03.impls;

import demi.demo.pack03.SomeService;

public class SomeServiceImpl implements SomeService {


    @Override
    public String around(String name, Integer age) {
        System.out.println("执行目标方法around()");
        return "around()执行结束";
    }
}
