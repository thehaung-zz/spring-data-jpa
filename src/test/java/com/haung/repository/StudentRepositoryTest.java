package com.haung.repository;

import com.haung.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudentCRUD() {
        Student student = Student.builder()
                .firstName("Hau")
                .lastName("Ng")
                .email("thehaung@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    void findListStudentByLastName() {
        List<Student> students = studentRepository.findListStudentByLastName("A");
        System.out.println(students);
    }

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    void findStudentByEmail() {
        Student student = studentRepository.findStudentByEmail("a1@gmail.com");
        System.out.println(student);
    }

    @Test
    void findListStudentByLastNameJPQL() {
        List<Student> student = studentRepository.findListStudentByLastNameJPQL("B");
        System.out.println(student);
    }

    @Test
    void findStudentByLastNameEmailJPQL() {
        Student student = studentRepository.findStudentByLastNameEmailJPQL("A", "a1@gmail.com");
        System.out.println(student);
    }

    @Test
    void findStudentByIdNative() {
        Student student = studentRepository.findStudentByIdNative(4L);
        System.out.println(student);
    }

    @Test
    void findAllStudentNative() {
        List<Student> students = studentRepository.findAllStudentNative();
        System.out.println(students);
    }

    @Test
    void updateStudentCRUD() {
        Optional<Student> op = studentRepository.findById(1L);
        Student student = op.get();
        student.setEmail("updateA1@gmail.com");
        Student a = studentRepository.save(student);
        System.out.println(a);
    }

    @Test
    void updateFirstNameStudentByIdJPQL() {
        studentRepository.updateFirstNameStudentByIdJPQL(1L, "UpdateA1");
        Optional<Student> op = studentRepository.findById(1L);
        Student student = op.get();
        System.out.println(student);
    }

    @Test
    void updateLastNameStudentByIdNative() {
        studentRepository.updateLastNameStudentByIdNative(2L, "Ng");
        Optional<Student> op = studentRepository.findById(2L);
        Student student = op.get();
        System.out.println(student);
    }

    @Test
    void deleteByStudentId() {
        studentRepository.deleteByStudentId(1L);
        List<Student> students = studentRepository.findAll();
        System.out.println(students);

    }

    @Test
    void deleteStudentByEmailJPQL() {
        studentRepository.deleteStudentByEmailJPQL("a2@gmail.com");
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    void deleteStudentByEmailNative() {
        studentRepository.deleteStudentByEmailNative("b@gmail.com");
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}