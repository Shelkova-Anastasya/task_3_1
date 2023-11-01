package com.springBoot.web.service;

import com.springBoot.web.DAO.DaoUser;
import com.springBoot.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class ServiceUserImp implements ServiceUser {

    private final DaoUser daoUser;
    @Autowired
    public ServiceUserImp(DaoUser daoCar) {
        this.daoUser = daoCar;
    }


    @Override
    public List<User> getUsers() {
        return daoUser.getUsers();
    }

    @Override
    public void saveUser(User user) {
    daoUser.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
     daoUser.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return daoUser.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
    daoUser.deleteUser(id);
    }
}


