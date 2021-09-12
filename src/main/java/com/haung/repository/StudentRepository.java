package com.haung.repository;


import com.haung.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student save(Student student);

    List<Student> findListStudentByLastName(String lastName);

    List<Student> findAll();

    Student findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.lastName=?1")
    List<Student> findListStudentByLastNameJPQL(String lastName);

    @Query("SELECT s FROM Student s WHERE s.lastName=?1 and s.email=?2")
    Student findStudentByLastNameEmailJPQL(String lastName, String email);

    @Query(value = "SELECT * FROM tbl_student WHERE student_id=?1", nativeQuery = true)
    Student findStudentByIdNative(Long id);

    @Query(value = "SELECT * FROM tbl_student s", nativeQuery = true)
    List<Student> findAllStudentNative();

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.firstName=?2 WHERE s.studentId=?1")
    void updateFirstNameStudentByIdJPQL(Long id, String firstName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tbl_student SET last_name=?2 WHERE student_id=?1", nativeQuery = true)
    void updateLastNameStudentByIdNative(Long id, String lastName);

    @Transactional
    @Modifying
    void deleteByStudentId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student e WHERE e.email=?1")
    void deleteStudentByEmailJPQL(String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tbl_student WHERE email=?1", nativeQuery = true)
    void deleteStudentByEmailNative(String email);
}
