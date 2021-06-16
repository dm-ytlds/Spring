package demi.demos;

import demi.demos.service.impl.someServiceImpl;
import demi.demos.service.someService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {
    @Test
    public void test01() {
        someService s = new someServiceImpl();
        s.something();
    }
    @Test
    public void test02() {
        // 使用spring容器创建java对象
        // 1.指定spring配置文件的路径
        String config = "beans.xml";
        // 2.创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就是表示spring 容器，通过容器来获取对象
        // ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件。
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中获取某个对象。getbean("配置文件中bean的id值")
        someService ss = (someService) ac.getBean("someService");
        ss.something();

    }
}
