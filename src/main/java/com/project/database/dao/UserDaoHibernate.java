package com.project.database.dao;

import java.util.List;

import com.project.database.entity.*;;

public interface UserDaoHibernate {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> getListUser();
}
