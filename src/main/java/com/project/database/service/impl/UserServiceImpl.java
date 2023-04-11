package com.project.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.dao.UserDao;
import com.project.database.model.UserDTO;
import com.project.database.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void addUser(UserDTO user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(UserDTO user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserDTO getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<UserDTO> getListUser() {
        return userDao.getListUser();
    }
}
