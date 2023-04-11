package com.project.database.service;

import java.util.List;

import com.project.database.entity.User;

public interface UserHibernateService {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> getListUser();
}
