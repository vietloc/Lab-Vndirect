package edu.hanoi.spring.dao;

import edu.hanoi.spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> list();

    String insert(User user);

    List<User> list(String name);

    public void delete(String name);
    public void update(User user);

    User get(String username);
//
//    List<User> list(Integer group);

    //random ra user
//    void addBatch();
}
