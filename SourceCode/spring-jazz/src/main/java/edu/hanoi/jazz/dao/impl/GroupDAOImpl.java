package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {
    private final static Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);
    @Autowired private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public void insert(Group group) {
        Session session = sessionFactoryBean.getObject().openSession();
        try{
            //luu vao group
            session.save(group);

//            session.flush();
            LOGGER.info("Save group " + group.getName() + " done!");
        } finally {
            session.close();
        }
        System.out.println(sessionFactoryBean+": Insert group "+ group);
    }

    @Override
    public void delete(int id){
        Session session = sessionFactoryBean.getObject().openSession();
        Group group = session.get(Group.class, id);
        if(group == null){
            return;
        }
        session.getTransaction().begin();
        session.delete(group);
        session.flush();
        session.getTransaction().commit();

        LOGGER.info("Delete group "+ group.getName() + " successful!");
        session.close();
    }

    @Override
    public Group get(Integer id) {
        Session session = sessionFactoryBean.getObject().openSession();
        Group group = session.get(Group.class, id);
        return group;
    }

    @Override
    public void update(Group group){
        Session session = sessionFactoryBean.getObject().openSession();
        group = (Group) session.merge(group);
        session.getTransaction().begin();
        session.save(group);
        session.flush();
        session.getTransaction().commit();
        LOGGER.info("Update group " + group.getName() + " seccessful!");
        session.close();
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactoryBean.getObject().openSession();
        Query query = session.createQuery("from Group");
        try{
            return (List<Group>) query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Group> list(String name) {
        Session session = sessionFactoryBean.getObject().openSession();
        if(name == null || name.length()<1){
            Query query = session.createQuery("from Group");
            try{
                return (List<Group>) query.list();
            } finally {
                session.close();
            }
        }
//        Criteria criteria = session.createCriteria(Group.class);
//        criteria.add(Restrictions.like("name", "%" + pattern + "%", MatchMode.ANYWHERE));
//        return new ArrayList<Group>(criteria.list());
        Query query = session.createQuery("from Group where name like :groupName");
        query.setParameter("groupName","%" + name + "%");
        return query.list();
    }
}
