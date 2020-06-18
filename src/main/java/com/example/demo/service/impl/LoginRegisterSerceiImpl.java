package com.example.demo.service.impl;

import com.example.demo.mapper.LoginRegisterMapper;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoginRegisterSerceiImpl implements LoginRegisterService {
    @Autowired
    private LoginRegisterMapper loginRegisterMapper;

    @Override
    public Student checkLogin(String stu_id, String stu_pwd) {
        return this.loginRegisterMapper.checkLogin(stu_id,stu_pwd);
    }

    @Override
    public void RegisterStudent(Integer stu_id, String stu_name, Timestamp create_time, Timestamp update_time,String stu_pwd) {
        this.loginRegisterMapper.RegisterStudent(stu_id,stu_name,create_time,update_time,stu_pwd);


    }

    @Override
    public Teacher checkLoginTea(String tea_id, String tea_pwd) {
        return this.loginRegisterMapper.checkLoginTea(tea_id,tea_pwd);
    }

    @Override
    public void RegisterTeacher(Integer tea_id, String username, Timestamp create_time, Timestamp update_time, String password) {
        this.loginRegisterMapper.RegisterTeacher(tea_id,username,create_time,update_time,password);

    }


}
