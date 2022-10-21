package edu.hanoi.spring.dao.impl;

import edu.hanoi.spring.dao.GroupDAO;
import edu.hanoi.spring.model.Group;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public void insert(Group group) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Group get(Integer id) {
        return null;
    }

    @Override
    public void update(Group group) {

    }

    public List<Group>list(){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            Query query = session.createQuery("from Group ");
            return (List<Group>) query.list();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Group> list(String name) {
        return null;
    }
}

