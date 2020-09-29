package com.xiuxiu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.*;
import com.xiuxiu.service.EmployeesService;
import com.xiuxiu.service.JobTaskService;
import com.xiuxiu.utils.JsonpUtils;
import com.xiuxiu.utils.httpUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author stone
 * @date 2020/9/24 002411:28
 */
@Controller
@RequestMapping("/emp")
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    @Autowired
    private JobTaskService jobservice;

        @RequestMapping("/getCode")
        public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            String redirect_uri = URLEncoder.encode("https://www.18725987688.com/job/loginByOpenId?", "UTF-8");
            StringBuffer url = new StringBuffer(
                    "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + "wx1eea06b76b80cd05" + "&redirect_uri=" + redirect_uri
                            + "&response_type=code&scope=snsapi_base&state=" + "1" + "#wechat_redirect");
            response.sendRedirect(url.toString());
        }
    @RequestMapping("/loginByOpenId")
    public void getCode(HttpSession session, HttpServletResponse response, String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String appId = "wx1eea06b76b80cd05";
        String secret = "046132a74d5bc05ec0d1a52b9c80f5b9";
        String params = "appid=" + appId + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = httpUtils.sendPostUrl(url, params);
        String OPENID = (String) jsonObject.get("openid");
        String ACCESS_TOKEN = (String) jsonObject.get("access_token");
        session.setAttribute("openid", OPENID);
        String url2 = "https://api.weixin.qq.com/sns/userinfo";
        String param2 = "access_token=" + ACCESS_TOKEN + "&openid=" + OPENID + "&lang=zh_CN";
        JSONObject jsonObject2 = httpUtils.sendPostUrl(url2, param2);
        String nickname = (String) jsonObject2.get("nickname");
        String headimgurl = (String) jsonObject2.get("headimgurl");
        WechatInfo weiXinUser = new WechatInfo();
        weiXinUser.setHeadimgurl(headimgurl);
        weiXinUser.setName(nickname);
        session.setAttribute("weiXinUser", weiXinUser);
        session.setAttribute("openid", OPENID);
        String redirectUrl ="";
        if(OPENID==null||OPENID==""){
             redirectUrl = "https://www.18725987688.com/job";
            response.sendRedirect(redirectUrl);
        }else{
            Employees employees = service.selectByOpenId(OPENID);
            if(null != employees){
                session.setAttribute("employees", employees);
            }
            session.setAttribute("ACCESS_TOKEN", ACCESS_TOKEN);
            if(null == employees){
                redirectUrl = "https://www.18725987688.com/job";
            }
            if("manage".equals(employees.getRole())){
                redirectUrl = "https://www.18725987688.com/job/jsp/jobtask/manageindex.jsp";
            }
            if("employee".equals(employees.getRole())){
                redirectUrl = "https://www.18725987688.com/job/jsp/jobtask/index.jsp";
            }
            response.sendRedirect(redirectUrl);
        }
    }





    @RequestMapping("/billsheet")
    public String billsheet(HttpSession session, Monthlybill employees){
        Result result = service.liveUpdate();
        Employees emp = (Employees) session.getAttribute("employees");
        if(emp.getRole().equals("manage")){
            employees.setId(null);
        }else {
            employees.setId(emp.getId());
            employees.setEmpname("");
        }
        PageHelper.startPage(1,20);
        List<Monthlybill> empsheet = service.billsheet(employees);
        PageInfo<Monthlybill> pageInfo = new PageInfo<>(empsheet);
        session.setAttribute("pageInfo",pageInfo);
        return "jobtask/performancekList";
    }
    @RequestMapping("/billsheetAjax")
    @ResponseBody
    public PageInfo billsheetAjax(HttpSession session,Integer pageNum, Monthlybill employees){
        Employees emp = (Employees) session.getAttribute("employees");
        if(emp.getRole().equals("manage")){
            employees.setId(null);
        }else {
            employees.setId(emp.getId());
            employees.setEmpname("");
        }
        PageHelper.startPage(pageNum,20);
        List<Monthlybill> empsheet = service.billsheet(employees);
        PageInfo<Monthlybill> pageInfo = new PageInfo<>(empsheet);
        return pageInfo;
    }


    @RequestMapping("/empsheet")
    public String empsheet(HttpSession session){
        Employees emp = (Employees) session.getAttribute("employees");
        Employees employees = jobservice.findEmployees(emp.getId());
        session.setAttribute("employees",employees);
        return "jobtask/home";
    }


}
