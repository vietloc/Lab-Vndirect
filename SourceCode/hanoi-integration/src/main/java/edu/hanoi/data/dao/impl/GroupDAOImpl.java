package edu.hanoi.data.dao.impl;

import edu.hanoi.data.dao.GroupDAO;
import edu.hanoi.data.model.Group;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;


    @Override
    public int add(Group group) {
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            return Integer.parseInt(session.save(group).toString());
        }finally {
            session.close();
        }
    }
}
