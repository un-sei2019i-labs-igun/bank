package com.example.bankapp.data_access.repositories;

import com.example.bankapp.data_access.models.User;
import com.example.bankapp.data_access.models.UserDao;

import java.util.Date;

public class UserRepository {
    private UserDao userDao;
    public UserRepository(UserDao userDao){
        this.userDao = userDao;
        mockData();
    }

    private void mockData(){
        User testUser = new User(123, "German Guerrero", "0000", new Date(), -1);
        create(testUser);
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
