package demi.demos;

import demi.demos.domain.Student;
//import demi.demos.domain.dao.StudentDao;
import demi.demos.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {
//    @Test
//    public void testDao() {
//        // 配置文件位置
//        String config = "applicationContext.xml";
//        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//        // 获取spring容器中的dao对象
//        StudentDao dao = (StudentDao) ac.getBean("studentDao");
//
//        // 测试插入功能
////        Student student = new Student();
////        student.setId(1200);
////        student.setName("hh");
////        student.setEmail("hh@qq.com");
////        student.setAge(20);
////        int nums = dao.insertStudent(student);
////        System.out.println(nums);
//
//
//        // 测试查询功能
//        List<Student> students = dao.selectStudents();
//        for(Student student1 : students) {
//            System.out.println(student1.toString());
//        }
//
//    }

    @Test
    public void testService() {
        // 配置文件位置
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 获取spring容器中的studentService对象
        StudentService service = (StudentService) ac.getBean("studentService");

//        // 测试插入功能
//        Student student = new Student();
//        student.setId(1201);
//        student.setName("yy");
//        student.setEmail("yy@qq.com");
//        student.setAge(22);
//        int nums = service.addStudent(student);
//        System.out.println("nums = " + nums);


        // 测试查询功能
        List<Student> students = service.queryStudents();
        for(Student student1 : students) {
            System.out.println(student1.toString());
        }

    }
}
