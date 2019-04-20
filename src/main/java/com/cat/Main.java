package com.cat;

import com.cat.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentFactory studentFactory = new StudentFactory();
        System.out.println(studentFactory.getAllStudents());
        System.out.println(studentFactory.getStudent(1));
        System.out.println(studentFactory.removeStudentById(1));
        System.out.println(studentFactory.removeStudentByName("Max"));
        System.out.println(studentFactory.updateStudent(3, "Max", 34));
        studentFactory.removeAllStudents();
        studentFactory.addStudent(new Student(5, "Olga", 33));
        System.out.println(studentFactory.getAllStudents());
        System.out.println("If you would like to save changes into database click Q, please");
        String saveString = scanner.nextLine();
        if (saveString.equals("Q") || saveString.equals("q")) {
            studentFactory.pushAllStudents();
        }
        if (saveString.equals("D") || saveString.equals("d")) {
            studentFactory.crashAll();
        }
    }
}
