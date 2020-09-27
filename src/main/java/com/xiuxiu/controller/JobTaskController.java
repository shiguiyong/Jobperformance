package com.xiuxiu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.*;
import com.xiuxiu.service.JobTaskService;
import com.xiuxiu.utils.JsonpUtils;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author stone
 * @date 2020/9/9 000912:10
 */
@Controller
@RequestMapping("/JobTask")
public class JobTaskController {

    @Autowired
    private  JobTaskService service;

    @RequestMapping(value = "login",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String login(HttpSession session,String callback,String account,String password){
        if(account == null){
            return JsonpUtils.Result(callback,new Result(2,"请正确输入您的员工账号"));
        }
        if(password == null || password== ""){
            return JsonpUtils.Result(callback,new Result(2,"请正确输入您的账号密码"));
        }
        Employees employees = new Employees();
        employees.setAccount(account);
        employees.setPassword(password);
        Result login = service.login(employees);
        if(login.getCode()==1){
            Employees emp = service.findEmployees(Integer.parseInt(login.getMessage()));
            session.setAttribute("employees",emp);
            if(emp.getRole().equals("manage")){
                login.setCode(3);
                return JsonpUtils.Result(callback,login);
            }
            return JsonpUtils.Result(callback,login);
        }
        return JsonpUtils.Result(callback,login);
    }

    @RequestMapping("/internallylogin")
    public  String internallylogin(HttpSession session,Employees employee){
        Result login = service.login(employee);
        Employees employees = service.findEmployees(Integer.parseInt(login.getMessage()));
        session.setAttribute("employees",employees);
        if(employees.getRole().equals("manage")){
            return "jobtask/manageindex";
        }
        return "jobtask/index";
    }

    @RequestMapping("/personalcenter")
    public  String personalcenter(HttpSession session){
        Employees emp = (Employees) session.getAttribute("employees");
        Employees employees = service.findEmployees(emp.getId());
       session.setAttribute("employees",employees);
        return "jobtask/personalcenter";
    }

    @RequestMapping("/updateEmp")
    @ResponseBody
    public  Result updateEmp(HttpSession session,Employees employees){
        Employees emp = service.updateEmp(employees);
        if(emp != null){
            session.setAttribute("employees",emp);
            return  new Result(1,"修改成功"+","+emp.getAccount()+","+emp.getPassword());

        }else {
            return  new Result(2,"修改失败");
        }
    }


    @RequestMapping("/queryAll")
    public  String queryAll(HttpSession session,Integer id){
        Employees employees = service.findEmployees(id);
        session.setAttribute("employees",employees);

        if(employees.getRole().equals("manage")){
            //return "jobtask/taskList";
            return "jobtask/managetaskList";
        }
        return "jobtask/taskList";
    }

    @RequestMapping("/queryAllAjax")
    @ResponseBody
    public  PageInfo queryallAjax(HttpSession session, Integer pageNum, Conditions conditions){
        long l = System.currentTimeMillis();
        Employees employees = (Employees) session.getAttribute("employees");
        if(employees.getRole().equals("manage")){
            conditions.setEmployeeId(null);
        }else {
            conditions.setEmployeeId(employees.getId());
        }
        PageInfo pageInfo = service.selectJobTask(pageNum, conditions);
        System.out.println(System.currentTimeMillis()-l+"ms");
        return pageInfo;
    }

    @RequestMapping("/queryDetailsAjax")
    @ResponseBody
    public  PageInfo queryDetailsAjax(HttpSession session, Integer pageNum, Conditions conditions){
        Employees employees = (Employees) session.getAttribute("employees");
        if(employees.getRole().equals("manage")){
            conditions.setEmployeeId(null);
        }else {
            conditions.setEmployeeId(employees.getId());
        }
        PageInfo pageInfo = service.selectJobTaskDetails(pageNum, conditions);
        return pageInfo;
    }

    @RequestMapping("/addOrUpdateTask")
    @ResponseBody
    public  Result addOrUpdateTask(Employeetask task , MultipartFile file){
        return service.addOrUpdateTask(task,file);
    }

    @RequestMapping("/getEmployees")
    @ResponseBody
    public List<Employees> getEmployees(){
        List<Employees> employees = service.getEmployees();
        return  employees;
    }
    @RequestMapping("/getTaskById")
    public String getTaskById(HttpSession session,Integer id){
        Employeetask task = service.getTaskById(id);
        List<Employees> employees = service.getEmployees();
        session.setAttribute("task",task);
        session.setAttribute("employeesList",employees);
        return  "jobtask/edittask";
    }

    @RequestMapping("/uploadsub")
    @ResponseBody
    public Result uploadsub(String remark,Integer id,@RequestParam MultipartFile file) throws IOException {
        Result upload = service.upload( remark, id,file);
        return upload;
    }

    @RequestMapping("/updateclaimStatus")
    @ResponseBody
    public Result updateclaimStatus(Integer id){
        Result upload = service.updateclaimStatus( id);
        return upload;
    }

    /**
     * 下载
     * @param response
     * @param fileurl
     *
     */
    @RequestMapping("/downloadLocal")
    public static void downloadLocal(HttpServletResponse response,String fileurl) throws IOException {
        String path = "D:\\job\\";
        File filename = new File(path+fileurl);
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        //设置可以识别Html文件  
        response.setContentType("text/html");
        String name = new String(filename.getName().getBytes(),"ISO-8859-1");
        // 2.设置文件头：最后一个参数是设置下载文件名  
        response.setHeader("Content-Disposition", "attachment;filename="+name);
        //（这里  可以设置成excel格式 ：response.setHeader("Content-Disposition", "attachment;fileName=" + “文件名” + ".xsl");
        //可以设置成.pdf格式 ：response.setHeader("Content-Disposition", "attachment;fileName=" + “文件名” + ".pdf");
        OutputStream out = response.getOutputStream();
        FileInputStream fileinput = new FileInputStream(filename);
        try {
            out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            while ((b = fileinput.read(buffer)) != -1) {
                // 4.写到输出流(out)中  
                out.write(buffer, 0, b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fileinput.close();
            out.flush();
            out.close();
        }
    }


    @RequestMapping("/lookImages")
    @ResponseBody
    public List<String> lookImages(Integer id) {
        return service.lookImages(id);
    }

    @RequestMapping("/checkStatus")
    @ResponseBody
    public Result checkStatus(Integer id,Integer type,String remark,@RequestParam MultipartFile file) throws IOException {
        return service.checkStatus(id,type,remark,file);
    }






  /*  @RequestMapping ( "/springUpload" )
    @ResponseBody
    public  Result  springUpload(HttpServletRequest request,Integer taskId)  throws  IllegalStateException, IOException {

        long   startTime=System.currentTimeMillis();
        String filepath = "";
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver= new  CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while (iter.hasNext())
            {

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if (file!= null )
                {
                    String path = "D：\\job\\word\\"+file.getOriginalFilename();
                    filepath = path;
                    //上传
                    file.transferTo( new  File(path));
                }

            }

        }

        service.updateTask(taskId,filepath);
        long   endTime=System.currentTimeMillis();
        System.out.println( "Spring方法的运行时间：" +String.valueOf(endTime-startTime)+ "ms" );
        return  new Result(1,"上传成功") ;
    }
*/

}
