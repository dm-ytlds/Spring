package demi.demos.pack01;

import demi.demos.pack01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {

    // 最初的创建对象的方式
    @Test
    public void test01() {
        Student s = new Student();
        s.setName("zs");
        s.setAge(23);
        System.out.println(s.toString());
    }

    // 用spring创建对象的方式
    @Test
    public void test02() {
        // 使用spring容器创建java对象
        // 1.指定spring配置文件的路径
        String config = "pack01/applicationContext.xml";
        // 2.创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就是表示spring 容器，通过容器来获取对象
        // ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件。
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中获取某个对象。getbean("配置文件中bean的id值")
        Student student = (Student) ac.getBean("stu");
        student.setName("ls");
        student.setAge(25);
        System.out.println(student.toString());
    }

    // 简单的set注入，结果测试
    @Test
    public void test03() {
        String config = "pack01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("stu_set_simple");
        System.out.println(student.toString());
    }
}
