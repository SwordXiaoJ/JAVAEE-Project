package com.example.demo.controller;

import com.example.demo.pojo.NeedHomework;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentHomework;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.LoginRegisterService;
import com.example.demo.service.NeedHomeworkService;
import com.example.demo.service.StudentHomeworkService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private NeedHomeworkService needHomeworkService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentHomeworkService studentHomeworkService;
    @Autowired
    private LoginRegisterService loginRegisterService;

    /**
     * restful风格跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String execute(@PathVariable String page){
        return page;
    }

    @RequestMapping("/register")
    public String Register(){
        return "Teacher/TeacherRegister";
    }

    @RequestMapping("/afterregister")
    public String AfterRegister(HttpServletRequest request){
        String t_id=request.getParameter("regis_t_id");
        String t_name=request.getParameter("regis_t_name");
        String t_pwd=request.getParameter("regis_t_pwd");
        Timestamp create_time=new Timestamp(System.currentTimeMillis());
        Timestamp update_time=create_time;

        Integer int_id  = Math.toIntExact(Long.parseLong(t_id));

        loginRegisterService.RegisterTeacher(int_id,t_name,create_time,update_time,t_pwd);



        return "Teacher/TeacherLogin";
    }


    @RequestMapping("/login")
    public String Login(){
        return "Teacher/TeacherLogin";
    }
    @RequestMapping("/teaOperation")
    public String StuOperation(HttpServletRequest request){

        String tea_id =request.getParameter("my_id");
        String tea_pwd=request.getParameter("my_pwd");

        Teacher s= loginRegisterService.checkLoginTea(tea_id,tea_pwd);


        if(s==null)
        {
            return "Teacher/TeacherLogin";
        }
        else
        {
            return "Teacher/TeacherOperation";
        }

    }


    @RequestMapping("/backtooperation")
    public String BackToOperation() {


        return "Teacher/TeacherOperation";

    }
    @RequestMapping("/addneed")
    public String AddNeed(){
        return "Teacher/AddNeedHomework";
    }

    @RequestMapping("/afteraddneed")
    public String  AfterAddNeed(Integer h_id, String h_title, String h_content, Timestamp create_time, Timestamp update_time,Model model){
        needHomeworkService.addNeedHomework(h_id, h_title, h_content, create_time, update_time);
        List<NeedHomework> needhomework_list=this.needHomeworkService.selectAllNeed();
        model.addAttribute("list",needhomework_list);
        return "ShowAllNeed";
    }

    @RequestMapping("/addstu")
    public String AddStu(){

        return "Teacher/AddStudent";
    }

    @RequestMapping("/afteraddstu")
    public String  AfterAddStu(Integer s_id, String s_name, Timestamp create_time, Timestamp update_time, Model model){
        System.out.println(s_id);
        System.out.println(s_name);
        studentService.addStudent(s_id,s_name,create_time,update_time);
        List<Student> student_list=this.studentService.selectAllStu();
        model.addAttribute("list",student_list);
        return "ShowAllStu";
    }
    @RequestMapping("/searchbycon")
    public String SearchByCon(){
        return "Teacher/SearchByCond";
    }

    @RequestMapping("/aftersearch")
    public String AfterSearch(Model model,String seastu_id,String seahome_id){

        List<StudentHomework> list=null;


        if(seastu_id=="")
        {
            list= studentHomeworkService.selectbyhome(seahome_id);

        }else if(seahome_id=="")
        {
            list = studentHomeworkService.selectbystu(seastu_id);
        }
        else
        {
            list = studentHomeworkService.selectbycross(seastu_id,seahome_id);
        }

        model.addAttribute("list",list);

        if(null == list || list.size() <= 0)
        {
            model.addAttribute("error","没有查询到指定数据");
        }
        else
        {
            model.addAttribute("error","");
        }

        return "ShowAllHome";
    }

    @RequestMapping("/allhome")
    public String ShowAll(Model model) {
        List<StudentHomework> list = this.studentHomeworkService.selectAll();
        model.addAttribute("list",list);
        System.out.println(list);
        return "ShowAllHome";
    }


    @RequestMapping("/generalreview")
    public String generalview(Model model) {

        List<StudentHomework> list = this.studentHomeworkService.selectAll();
        model.addAttribute("list",list);
        return "Teacher/GeneralReview";
    }

    @RequestMapping("/reviewhome")
    public String reviewhome(String id, Model model) {
        StudentHomework reviewhomework = studentHomeworkService.selectbyID(id);


        model.addAttribute("review",reviewhomework);

        return "Teacher/ReviewHomework";
    }
    @RequestMapping("/afterreviewhome")
    public String Afeterreviewhome(HttpServletRequest request,Model model) {
        String id_str =request.getParameter("all_id");


        String s_id_str =request.getParameter("s_id");
        String h_id_str =request.getParameter("h_id");
        String h_title=request.getParameter("h_title");
        String h_content=request.getParameter("h_content");

        Integer h_id  = Math.toIntExact(Long.parseLong(h_id_str));
        Integer s_id  = Math.toIntExact(Long.parseLong(s_id_str));
        Integer id  = Math.toIntExact(Long.parseLong(id_str));

        Timestamp update_time=new Timestamp(System.currentTimeMillis());

        String h_review = request.getParameter("h_review");

        studentHomeworkService.reviewStudentHomework(id,h_title,h_review);




        String nInfo=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            nInfo = cookie.getValue();
        }

        List<StudentHomework> list = this.studentHomeworkService.selectAll();
        model.addAttribute("list",list);
        return "ShowAllHome";

    }

}
