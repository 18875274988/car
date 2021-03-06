package com.sys.service.serviceImpl;

import com.sys.dao.UserDao;
import com.sys.entity.UserPo;
import com.sys.service.UserService;
import com.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author liu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserVo login(String username,String password) {
        UserVo userVo = new UserVo();
        if (username.equals("") || password.equals("")){
            userVo.setStatus(2);
            return userVo;
        }
        UserPo userlogin = userDao.login(username);
        if (null==userlogin){
            userVo.setStatus(2);
            return userVo;
        }
        if(password.equals(userlogin.getPassword())){
            userVo.setStatus(1);
            userVo.setState(userlogin.getState());
        }

        return userVo;
    }

    @Override
    public int updatePassword(String password,String username) {
        int rows = userDao.updatePassword(username,password);
        return rows;
    }
    @Override
    public UserPo findByUsername(String username) {
        UserPo userPo = userDao.findByUsername(username);
        return userPo;
    }

    @Override
    public int addUser(UserPo userPo) {
        int rows = userDao.addUser(userPo);
        return rows;
    }
}
