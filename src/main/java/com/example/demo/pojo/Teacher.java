package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private long tea_id;
    private String name;
    private Timestamp createTime;
    private Timestamp updateTime;
}
