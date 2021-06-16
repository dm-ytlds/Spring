package demi.demos.pack04;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {
    @Test
    public void testConstruct01() {
        String config = "pack04/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student stu = (Student) ac.getBean("stu_auto");
        System.out.println(stu);
    }
}
