package com.cashbook.service;

import com.cashbook.entity.User;
import com.cashbook.dao.UserDao;

public class UserService {
    UserDao userDao = new UserDao();

    public boolean userCheck(User user) {
        boolean flag = false;
        User _user = userDao.getUserByUsername(user.getUsername());
        if (_user != null && user.getPassword().equals(_user.getPassword()))
            flag = true;
        return flag;
    }

    public void addUser(User user) {
        userDao.add(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
