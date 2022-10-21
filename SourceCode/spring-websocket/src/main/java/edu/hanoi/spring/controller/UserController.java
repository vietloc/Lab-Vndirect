package edu.hanoi.spring.controller;

import edu.hanoi.spring.dao.UserDAO;
import edu.hanoi.spring.model.Message;
import edu.hanoi.spring.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(UserController.class));


    @Autowired
    private UserDAO userDAO;

    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user){
//        System.out.println("user: " + user.getUsername() +" - email "+user.getEmail());
        String status = userDAO.insert(user);
        return new Message("Save " + status + " successful!");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> listUser(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        LOGGER.info("\n-------------> " + auth.getAuthorities());
        return userDAO.list();
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
