package demi.demos.pack02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {
    @Test
    public void testSet01() {
        String config = "pack02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("stu_set");
        System.out.println(student);
    }
}
