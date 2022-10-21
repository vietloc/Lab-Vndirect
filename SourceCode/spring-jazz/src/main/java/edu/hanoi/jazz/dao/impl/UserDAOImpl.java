package edu.hanoi.jazz.dao.impl;


import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

//    private final static int SIZE_OF_PAGE = 2;

    @Override
    public void insert(User user) {
        Session session = sessionFactoryBean.getObject().openSession();
        try{
            session.getTransaction().begin();
            //luu vao user
            session.save(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user " + user.getUsername() + " done!");
        } finally {
            session.close();
        }
        System.out.println(sessionFactoryBean+": Insert user "+ user);
    }

    @Override
    public List<User> list(String name) {
        Session session = sessionFactoryBean.getObject().openSession();
        Query query = session.createQuery("from User");
        try{
            return (List<User>) query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(String name){
        Session session = sessionFactoryBean.getObject().openSession();
        String hql = "delete from User where username like :name";
        Query query = session.createQuery(hql);
        session.getTransaction().begin();
        query.setParameter("name", name);
        Integer result = query.executeUpdate();
        session.getTransaction().commit();
        LOGGER.info("Rows affected: " + result + "\n\n");
        session.close();
    }

    @Override
    public User get(String username) {
        Session session = sessionFactoryBean.getObject().openSession();
        User user = session.get(User.class, username);
        return user;
    }

    @Override
    public List<User> list(Integer group) {
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            if (group == null || group < 0) {
                Query query = session.createQuery("from User order by age desc");
                return (List<User>) query.list();
            }
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("groupId", group));
            return new ArrayList<User>(criteria.list());
        }
         finally {
                session.close();
            }
        }
        public List<User>listOlder(){
            Session session = sessionFactoryBean.getObject().openSession();
//            Criteria cr = session.createCriteria(User.class);
//            cr.add(Restrictions.gt("age", 50));
//            return (List<User>) cr.list();
            String sql = "select*from HN_USER where age<:value";
            NativeQuery query = session.createSQLQuery(sql);
            query.setParameter("value", 50);
            query.addEntity(User.class);
            return query.list();
        }
        public int averageAge(){
            Session session = sessionFactoryBean.getObject().openSession();
            Criteria cr = session.createCriteria(User.class);
            cr.setProjection(Projections.avg("age"));
            List avgAge = cr.list();
            return ((Double)avgAge.get(0)).intValue();
        }

//        public List<User> page(int page){
//            Session session = sessionFactoryBean.getObject().openSession();
//            Criteria cr = session.createCriteria(User.class);
//            int start = (page - 1)*SIZE_OF_PAGE;
//            cr.setFirstResult(start);
//            cr.setMaxResults(SIZE_OF_PAGE);
//            return (List<User>) cr.list();
//        }

        public List<User> listUserByNativeSQL(){
            Session session = sessionFactoryBean.getObject().openSession();
            String sql = "select*from HN_USER";
            NativeQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            return query.list();
        }

        //random ra user
    @Override
    public void addBatch() {
        Session session = sessionFactoryBean.getObject().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0;i < 50;i++){
                session.save(UserFactory.generate(i+1));
            }
//            session.getTransaction().begin();
            session.flush();
            tx.commit();
//            session.getTransaction().commit();
        } catch (HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            LOGGER.error(e,e);
        }finally {
            session.close();
        }
    }
}
