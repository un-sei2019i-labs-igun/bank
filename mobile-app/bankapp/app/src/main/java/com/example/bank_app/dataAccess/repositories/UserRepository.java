package com.example.bank_app.dataAccess.repositories;

import com.example.bank_app.dataAccess.models.User;
import com.example.bank_app.dataAccess.models.UserDao;

public class UserRepository extends Repository{

    private UserDao userDao;
    public UserRepository(UserDao userDao){
        this.userDao = userDao;
    }

    public User create(User user){
        userDao.insert(user);
        return user;
    }

    public User getById(long id){
        return userDao.load(id);
    }

    public User update(User user){
        userDao.update(user);
        return  user;
    }

}
