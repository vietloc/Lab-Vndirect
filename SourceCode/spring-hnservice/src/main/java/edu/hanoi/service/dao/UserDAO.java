package edu.hanoi.service.dao;

import edu.hanoi.service.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;

public interface UserDAO {
    List<User> list();

    int insert(User user);
    public void delete(String name);
    public void update(User user);

    User get(String username);
}
