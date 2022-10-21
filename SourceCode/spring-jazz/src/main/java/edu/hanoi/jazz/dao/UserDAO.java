package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserDAO {
    void insert(User user);

    List<User> list(Integer group);

    List<User> list(String name);

    void delete(String name);

    public User get(String username);

    List<User> listOlder();

    public int averageAge();

//    List<User>page(int page);

    List<User> listUserByNativeSQL();

    void addBatch();
}
