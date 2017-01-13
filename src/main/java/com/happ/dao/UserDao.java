package com.happ.dao;

import com.happ.model.User;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
}