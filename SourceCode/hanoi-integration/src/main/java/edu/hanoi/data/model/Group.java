package edu.hanoi.data.model;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.SortedSet;


@javax.persistence.Entity
@Table(name = "HN_GROUP", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group {
    private String name;
    private int id;

    public Group(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Group() {

    }
//    private SortedSet<User> users;


    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "groupId")
//    @SortNatural
//    @SortComparator(UsernameComparator.class)
//    public SortedSet<User> getUsers() {
//        return users;
//    }

//    public void setUsers(SortedSet<User> users) {
//        this.users = users;
//    }
}
