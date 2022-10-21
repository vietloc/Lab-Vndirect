package edu.hanoi.spring.dao;

import edu.hanoi.spring.model.Group;

import java.util.List;

public interface GroupDAO {

    void insert(Group group);

    void delete(int id);

    Group get(Integer id);

    void update(Group group);

    List<Group> list();

    List<Group> list(String name);
}
