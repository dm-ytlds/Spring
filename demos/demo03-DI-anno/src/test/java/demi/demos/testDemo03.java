package demi.demos;

import demi.demos.pack03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo03 {
    @Test
    public void testDiAnno() {
        String config = "pack03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student stu = (Student) ac.getBean("student");
        System.out.println(stu);
    }
}
