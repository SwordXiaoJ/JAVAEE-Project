package com.example.demo.mapper;

import com.example.demo.pojo.StudentHomework;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface StudentHomeworkMapper {

    List<StudentHomework> selectAll();
    void addStudentHomework(@Param("home_id") Integer home_id,@Param("stu_id") Integer stu_id,
                            @Param("title") String title, @Param("content") String content, @Param("create_time") Timestamp create_time,
                            @Param("update_time") Timestamp update_time,@Param("review") String review );
    List<StudentHomework> selectmy(String my_id);
    List<StudentHomework> selectbystu(String stu_id);
    List<StudentHomework> selectbyhome(String home_id);
    List<StudentHomework> selectbycross(String stu_id,String home_id);

    StudentHomework selectbyID(String id);
    void updateStudentHomework(@Param("id") Integer id,
                               @Param("title") String title, @Param("content") String content,
                               @Param("update_time") Timestamp update_time);

    void reviewStudentHomework(@Param("id") Integer id,
                               @Param("title") String title, @Param("review") String review);

    void deleteStudentHomework(String id);
}
