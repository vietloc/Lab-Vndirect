package edu.hanoi.spring.dao.impl;

import edu.hanoi.spring.dao.UserDAO;
import edu.hanoi.spring.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(UserDAOImpl.class));

    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    @Qualifier(value = "sessionFactory")
    public void setSessionFactoryBean(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    public LocalSessionFactoryBean getSessionFactoryBean() {
        return sessionFactoryBean;
    }

    public List<User> list(){
        Session session = sessionFactoryBean.getObject().openSession();

        try {
            Query query = session.createQuery("from User order by age desc ");
            return (List<User>) query.list();
        } finally {
            session.close();
        }
    }

    public String insert(User user){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            Serializable value = session.save(user);
            session.getTransaction().begin();
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user " + user.getUsername() + " done!" + value);
            return value.toString();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> list(String name) {
        Session session = sessionFactoryBean.getObject().openSession();

        try {
            Query query = session.createQuery("from User order by age desc ");
            return (List<User>) query.list();
        } finally {
            session.close();
        }
    }

    public User get(String username){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            return session.get(User.class, username);
        } finally {
            session.close();
        }
    }

    public void delete(String name){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            User user = session.get(User.class, name);
            if(user!=null){
                session.delete(user);
            }
            session.getTransaction().begin();
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    public void update(User user){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
