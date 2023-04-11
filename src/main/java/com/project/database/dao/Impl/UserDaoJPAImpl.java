package com.project.database.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import com.project.database.dao.UserDaoHibernate;
import com.project.database.dao.UserDaoJPA;
import com.project.database.entity.User;

@Transactional ("transactionManager")
public class UserDaoJPAImpl implements UserDaoHibernate{

    // Việc đặt @Lazy để tránh cơ chế vòng lặp bean có thể xảy ra và gây ra lỗi
    @Autowired
    @Lazy
    UserDaoJPA userDaoJPA;

    @Override
    public void addUser(User user) {
        userDaoJPA.save(user);
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
        if (userDaoJPA.findById( id).isPresent()) 
            return userDaoJPA.findById(id).get();
        else return null;
    }

    @Override
    public List<User> getListUser() {
        return userDaoJPA.findAll();
    }
}
