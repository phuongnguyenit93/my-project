package com.project.database.dao;

import java.util.List;

import com.project.database.model.UserDTO;

public interface UserDao {
    public void addUser(UserDTO user);
    public void updateUser(UserDTO user);
    public void deleteUser(int id);
    public UserDTO getUserById(int id);
    public List<UserDTO> getListUser();
}
