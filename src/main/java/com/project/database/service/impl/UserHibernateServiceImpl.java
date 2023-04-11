package com.project.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.dao.Impl.UserDaoHibernateImpl;
import com.project.database.entity.User;
import com.project.database.service.UserHibernateService;

@Service
public class UserHibernateServiceImpl implements UserHibernateService {

    @Autowired
    UserDaoHibernateImpl userDaoHibernateImpl;

    @Override
    public void addUser(User user) {
        userDaoHibernateImpl.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDaoHibernateImpl.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDaoHibernateImpl.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDaoHibernateImpl.getUserById(id);
    }

    @Override
    public List<User> getListUser() {
        return userDaoHibernateImpl.getListUser();
    }
    
}
