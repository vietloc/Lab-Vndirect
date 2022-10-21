package edu.hanoi.spring.controller;

import edu.hanoi.spring.dao.GroupDAO;
import edu.hanoi.spring.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupDAO groupDAO;

    @RequestMapping(value = "/groups")
    public List<Group> listGroups(){
        return groupDAO.list();
    }

}
