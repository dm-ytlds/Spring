package demi.demo;

import demi.demo.pack02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest02 {
    @Test
    public void testAspectJ() {
        String config = "pack02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService ss = (SomeService) ac.getBean("someService02");
        ss.doSome("ls", 23);
        ss.doOther("zs", 25);
    }
}
