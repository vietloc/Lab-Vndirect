package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;
import org.hibernate.Session;

import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public interface GroupDAO {
    public void insert(Group group);

    public void update(Group group);

    public List<Group> list();

    public void delete(int id);

    Group get(Integer id);

    List<Group> list(String pattern);
}
