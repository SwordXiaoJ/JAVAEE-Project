package com.example.demo.controller;

import com.example.demo.pojo.NeedHomework;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentHomework;
import com.example.demo.service.LoginRegisterService;
import com.example.demo.service.NeedHomeworkService;
import com.example.demo.service.StudentHomeworkService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
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
        return "Student/StudentRegister";
    }

    @RequestMapping("/afterregister")
    public String AfterRegister(HttpServletRequest request){
        String s_id=request.getParameter("regis_id");
        String s_name=request.getParameter("regis_name");
        String s_pwd=request.getParameter("regis_pwd");
        Timestamp create_time=new Timestamp(System.currentTimeMillis());
        Timestamp update_time=create_time;

        Integer int_id  = Math.toIntExact(Long.parseLong(s_id));

        loginRegisterService.RegisterStudent(int_id,s_name,create_time,update_time,s_pwd);



        return "Student/StudentLogin";
    }


    @RequestMapping("/login")
    public String Login(){
        return "Student/StudentLogin";
    }
    @RequestMapping("/stuOperation")
    public String StuOperation(HttpServletRequest request){

        String stu_id =request.getParameter("my_id");
        String stu_pwd=request.getParameter("my_pwd");

        Student s= loginRegisterService.checkLogin(stu_id,stu_pwd);

        if(s==null)
        {
            return "Student/StudentLogin";
        }
        else
        {
            return "Student/StudentOperation";
        }

    }

    @RequestMapping("/backtooperation")
    public String BackToOperation() {


        return "Student/StudentOperation";

    }

    @RequestMapping("/myhomework")
    public String MyHomework(HttpServletRequest request,Model model){
        String nInfo=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            nInfo = cookie.getValue();
        }

        List<StudentHomework> list = studentHomeworkService.selectmy(nInfo);
        System.out.println(list);
        model.addAttribute("list",list);
        return "Student/MyHomework";
    }
    @RequestMapping("/needhomework")
    public String NeedHomwork(Model model){
        List<NeedHomework> needlist = needHomeworkService.selectAllNeed();
        model.addAttribute("list",needlist);
        return "ShowAllNeed";
    }
    @RequestMapping("/submithome")
    public String submithome() {
        return "Student/SubmitHome";
    }

    @RequestMapping("/aftersubmithome")
    public String  aftersubmithome(HttpServletRequest request,Model model){

        String s_id_str =request.getParameter("s_id");
        String h_id_str =request.getParameter("h_id");
        String h_title=request.getParameter("h_title");
        String h_content=request.getParameter("h_content");

        List<StudentHomework> temp = studentHomeworkService.selectAll();
        int allid=temp.size();
        allid+=1;

        String allidstr=String.valueOf(allid);

        Integer id  = Math.toIntExact(Long.parseLong(allidstr));
        Integer h_id  = Math.toIntExact(Long.parseLong(h_id_str));
        Integer s_id  = Math.toIntExact(Long.parseLong(s_id_str));


        Timestamp create_time=new Timestamp(System.currentTimeMillis());
        Timestamp update_time=create_time;

        String review="null";

        studentHomeworkService.addStudentHomework(s_id, h_id, h_title, h_content, create_time, update_time,review);

        List<StudentHomework> stuhomework_list = this.studentHomeworkService.selectAll();
        System.out.println(stuhomework_list);

        model.addAttribute("list",stuhomework_list);
        return "ShowAllHome";
    }

    @RequestMapping("/updatehome")
    public String updatehome(String id, Model model) {

        StudentHomework updatehomework = studentHomeworkService.selectbyID(id);

        model.addAttribute("update",updatehomework);

        return "Student/UpdateHomework";
    }
    @RequestMapping("/afterupdatehome")
    public String Afeterupdatehome(HttpServletRequest request,Model model) {
        String id_str =request.getParameter("all_id");
        System.out.println(id_str);

        String s_id_str =request.getParameter("s_id");
        String h_id_str =request.getParameter("h_id");
        String h_title=request.getParameter("h_title");
        String h_content=request.getParameter("h_content");

        System.out.println(h_content);
        Integer h_id  = Math.toIntExact(Long.parseLong(h_id_str));
        Integer s_id  = Math.toIntExact(Long.parseLong(s_id_str));
        Integer id  = Math.toIntExact(Long.parseLong(id_str));

        Timestamp update_time=new Timestamp(System.currentTimeMillis());


        studentHomeworkService.updateStudentHomework(id,h_title,h_content,update_time);




        String nInfo=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            nInfo = cookie.getValue();
        }

        List<StudentHomework> list = studentHomeworkService.selectmy(nInfo);
     
        model.addAttribute("list",list);
        return "Student/MyHomework";

    }

    @RequestMapping("/lookreviewhome")
    public String lookreviewhome(String id, Model model) {


        StudentHomework updatehomework = studentHomeworkService.selectbyID(id);

        model.addAttribute("update",updatehomework);return "Student/LookReviewHome";
    }

    @RequestMapping("/afterdeletehome")
    public String Afeterdeletehome(String id,Model model,HttpServletRequest request) {

        System.out.println(id);

        studentHomeworkService.deleteStudentHomework(id);



        String nInfo=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            nInfo = cookie.getValue();
        }

        List<StudentHomework> list = studentHomeworkService.selectmy(nInfo);
        model.addAttribute("list",list);
        return "Student/MyHomework";

    }

}
