package demi.demos.service.impl;

import demi.demos.domain.Student;
import demi.demos.domain.dao.StudentDao;
import demi.demos.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    // 引用类型
    private StudentDao studentDao;

    // 使用set注入，赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
