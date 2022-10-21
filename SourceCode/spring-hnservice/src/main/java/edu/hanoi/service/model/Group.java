package edu.hanoi.service.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "HN_GROUP", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group{

    private String name;
    private int id;

    public Group(){};

    @Column(name = "name", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
