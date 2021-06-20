package demi.demo;

import demi.demo.pack01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest01 {
    @Test
    public void testAspectJ() {
        String config = "pack01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService ss = (SomeService) ac.getBean("someService");
        ss.doSome("ls", 23);
    }
}
