package com.example.demo.service;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface LoginRegisterService {
    Student checkLogin(String stu_id, String stu_pwd);
    void RegisterStudent(Integer stu_id, String stu_name,
                         Timestamp create_time,Timestamp update_time,String stu_pwd);
    Teacher checkLoginTea(String tea_id, String tea_pwd);
    void RegisterTeacher(Integer tea_id, String username,
                         Timestamp create_time,  Timestamp update_time, String password);
}
