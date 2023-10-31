package com.springBoot.web.DAO;

import com.springBoot.web.model.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public class DaoUserImp implements DaoUser {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public DaoUserImp(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }
    @Transactional
    @Override
    public void updateUser(User user) {
         entityManager.merge(user);

    }
    @Transactional
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
