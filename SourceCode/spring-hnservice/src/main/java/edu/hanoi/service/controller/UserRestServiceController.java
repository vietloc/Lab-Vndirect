package edu.hanoi.service.controller;

import edu.hanoi.service.dao.GroupDAO;
import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.dao.impl.UserDAOImpl;
import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserRestServiceController {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(UserRestServiceController.class));
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GroupDAO groupDAO;

//    @PostFilter("filterObject.username == 'username-random45'")
    @RequestMapping(value = "/list/users")
    @PreAuthorize("hasRole('USER')")
    @PostFilter("hasPermission(filterObject,'read')")
    public List<User> listUser(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("\n-------------> " + auth.getAuthorities());
//        return userDAO.list();
//        if(!request.isUserInRole("ROLE_ADMIN")){
//            throw new RuntimeException("Access Denied!");
//        }
        return userDAO.list();
    }

    public List<User> listUser1(HttpServletRequest request){
        if(!request.isUserInRole("ROLE_ADMIN")){
            throw new RuntimeException("Access Denied!");
        }
        return userDAO.list();
    }

    @RequestMapping(value = "/list/groups")
    public List<Group> listGroups(){
        return groupDAO.list();
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return String.valueOf(userDAO.insert(user));
    }

    @RequestMapping(value = "/delete/user/{name}", method = RequestMethod.GET)
    public void delUser(String name){
        userDAO.delete(name);
    }

    @RequestMapping(value = "/get/user/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name){
        return userDAO.list().get(Integer.parseInt(name));
    }

    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public void updateUser(User user){
        userDAO.update(user);
    }
}
