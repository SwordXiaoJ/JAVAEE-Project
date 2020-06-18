package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface LoginRegisterMapper {
    Student checkLogin(String stu_id, String stu_pwd);
    void RegisterStudent(@Param("student_id") Integer stu_id, @Param("name") String username,
                         @Param("create_time") Timestamp create_time, @Param("update_time") Timestamp update_time,@Param("password") String password);

    Teacher checkLoginTea(String tea_id, String tea_pwd);
    void RegisterTeacher(@Param("teacher_id") Integer tea_id, @Param("name") String username,
                         @Param("create_time") Timestamp create_time, @Param("update_time") Timestamp update_time,@Param("password") String password);
}
