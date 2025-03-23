package com.lce.service;

import com.lce.dao.UserDao;
import com.lce.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private final UserDao userDao = new UserDao();

    public boolean register(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userDao.insertUser(user);

    }

    //验证
    public boolean login(String username, String password) {
        User user = userDao.findUser(username);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
}
