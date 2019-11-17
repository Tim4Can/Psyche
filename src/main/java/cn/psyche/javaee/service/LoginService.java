package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service("loginService")
public class LoginService {

    @Autowired
    private StudentDao studentDao;

    public  Result login(int id, String pwd,HttpSession session){

        Optional<Student> optional=studentDao.findByIdAndPassword(id,pwd);

        if(optional.isPresent()){
            session.setAttribute(ConstantUtils.USER_SESSION_KEY,optional.get());
            session.setMaxInactiveInterval(3600); //lasts an hour.
            Student s=new Student();
            s.copy(optional.get());
            return ResultUtil.success(s);
        }else{
            return ResultUtil.type(ResultEnum.LOGIN_FAIL);
        }


    }
}



