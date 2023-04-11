package com.project.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.dao.Impl.UserDaoJPAImpl;
import com.project.database.entity.User;
import com.project.database.service.UserHibernateService;

@Service
public class UserJPAServiceImpl implements UserHibernateService {

    @Autowired
    UserDaoJPAImpl userDaoJPAImpl;

    @Override
    public void addUser(User user) {
        userDaoJPAImpl.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public User getUserById(int id) {
        return userDaoJPAImpl.getUserById(id);
    }

    @Override
    public List<User> getListUser() {
        return userDaoJPAImpl.getListUser();
    }
    
}
