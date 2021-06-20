package demi.demo;

import demi.demo.pack03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest03 {
    @Test
    public void testAspectJ() {
        String config = "pack03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService ss = (SomeService) ac.getBean("someService03");
        String s = ss.around("ls", 24);
        System.out.println(s);
    }
}
