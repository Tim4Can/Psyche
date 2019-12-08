package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.entity.StudentNoPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service("loginService")
public class LoginService {

    @Autowired
    private StudentDao studentDao;

    public  Result login(int id, String pwd,HttpSession session){

        Optional<StudentNoPwd> optional=studentDao.findByIdAndPassword(id,pwd);

        if(optional.isPresent()){
            session.setAttribute(ConstantUtils.USER_SESSION_KEY,id);
            session.setMaxInactiveInterval(3600); //lasts an hour.
            return ResultUtil.success(optional.get());
        }else{
            return ResultUtil.error(ResultEnum.LOGIN_FAIL);
        }


    }
}



