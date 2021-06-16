package demi.demos.pack03;

import demi.demos.pack03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {
    @Test
    public void testConstruct01() {
        String config = "pack03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("stu_construct");
        System.out.println(student);
    }
}
