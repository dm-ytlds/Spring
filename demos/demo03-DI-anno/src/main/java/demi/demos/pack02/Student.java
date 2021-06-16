package demi.demos.pack02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component(value = "student")
// value可以省略
//@Component("student")
// 也可以直接只写@Component，这样默认的value值是类名的首字母小写名称student
@Component
public class Student {
    @Value("zs")
    private String name;
    @Value("25")
    private int age;

    // 推荐将@Autowired放在属性定义的上面
    // 注解之引用数据类型的自动注入。默认是byType
    @Autowired
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 当然，也可以将注解放在属性对应的set方法的上面
    // @Autowired
    public void setSchool(School school) {
        this.school = school;
    }
}
