package edu.hanoi.service.dao.impl;

import edu.hanoi.service.dao.GroupDAO;
import edu.hanoi.service.model.Group;
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

    public List<Group>list(){
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            Query query = session.createQuery("from Group ");
            return (List<Group>) query.list();
        }finally {
            session.close();
        }
    }
}
