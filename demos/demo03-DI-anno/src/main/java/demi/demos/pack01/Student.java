package demi.demos.pack01;

import org.springframework.stereotype.Component;

//@Component(value = "student")
// value可以省略
//@Component("student")
// 也可以直接只写@Component，这样默认的value值是类名的首字母小写名称student
@Component
public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
