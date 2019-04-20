package com.cat;

import com.cat.dao.MariaDBDao;
import com.cat.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {
    private List<Student> studentList = new ArrayList<>();
    private MariaDBDao mariaDBDao = new MariaDBDao();

    public StudentFactory() {
        studentList = mariaDBDao.getAll();
        if (studentList.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    public void removeAllStudents() {
        studentList.removeAll(studentList);
    }

    public List<Student> removeStudentById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(studentList.get(i));
            }
        }
        return studentList;
    }

    public List<Student> removeStudentByName(String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)) {
                studentList.remove(studentList.get(i));
            }
        }
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> updateStudent(int id, String name, int age) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.get(i).setName(name);
                studentList.get(i).setAge(age);
            }
        }
        return studentList;
    }

    public Student getStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void pushAllStudents() {
        mariaDBDao.pushAll(studentList);
    }

    public void crashAll() {
        mariaDBDao.dropTable();
    }
}
