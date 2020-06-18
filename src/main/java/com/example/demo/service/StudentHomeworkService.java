package com.example.demo.service;

import com.example.demo.pojo.StudentHomework;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface StudentHomeworkService {
    List<StudentHomework> selectAll();
    void addStudentHomework(Integer home_id, Integer stu_id,String title,
                            String content,  Timestamp create_time, Timestamp update_time,String review);
    List<StudentHomework> selectmy(String my_id);
    List<StudentHomework> selectbystu(String stu_id);
    List<StudentHomework> selectbyhome(String home_id);
    List<StudentHomework> selectbycross(String stu_id,String home_id);
    StudentHomework selectbyID(String id);
    void updateStudentHomework( Integer id,
                               String title, String content,
                               Timestamp update_time);

    void reviewStudentHomework( Integer id,
                                String title, String review);

    void deleteStudentHomework(String id);
}
