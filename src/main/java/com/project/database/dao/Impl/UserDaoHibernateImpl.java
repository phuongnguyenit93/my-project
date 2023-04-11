package com.project.database.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.database.dao.UserDaoHibernate;
import com.project.database.entity.User;


// Do đang vừa liên kết JDBC và Hibernate cùng 1 lúc . Spring sẽ có 2 bean là 
// hibernateTransactionManager và dataSourceTransactionManager
// Nên phải ghi value tại transactional để biết Spring xài bean nào
@Repository
@Transactional (transactionManager = "hibernateTransactionManager")
public class UserDaoHibernateImpl implements UserDaoHibernate {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> getListUser() {
        Query <User> query = sessionFactory.openSession().createQuery("FROM User",User.class);
        List <User> users = query.getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().delete(getUserById(id));
    }

    @Override
    public User getUserById(int id) {
        return sessionFactory.openSession().get(User.class, id);
    }
    
}
