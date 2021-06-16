package demi.demos;

import demi.demos.pack01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo01 {
    @Test
    public void testDiAnno() {
        String config = "pack01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student stu = (Student) ac.getBean("student");
        stu.setName("ls");
        stu.setAge(23);
        System.out.println(stu);
    }
}
