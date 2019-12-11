package cn.psyche.javaee.config;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.util.ConstantUtils;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultEnum;
import cn.psyche.javaee.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //for login
        String path = request.getServletPath();
        if(path.matches(ConstantUtils.NO_INTERCEPTOR_PATH)){
            System.out.println("login pass");
            return true;
        }

        //have login
        HttpSession session=request.getSession();
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY)!=null){
            System.out.println("user pass");
            return true;
        }

        //not login
        returnJson(response, ResultUtil.error(ResultEnum.NOT_LOGIN));
        System.out.println("not pass");
        return false;

    }


    private void returnJson(HttpServletResponse response, Result result) throws Exception{
        PrintWriter writer=null;
        response.setCharacterEncoding(("UTF-8"));
        response.setContentType("text/html;charset=utf-8");
        try{
            writer=response.getWriter();
            writer.print(result);
        }catch (IOException e){
            logger.error("response error");

        }finally {
            if(writer!=null)
                writer.close();
        }
    }

}
