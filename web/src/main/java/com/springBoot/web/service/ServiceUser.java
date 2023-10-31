package com.springBoot.web.service;



import com.springBoot.web.model.User;

import java.util.List;

public interface ServiceUser {
    List<User> getUsers();
    void saveUser(User user);
  void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}