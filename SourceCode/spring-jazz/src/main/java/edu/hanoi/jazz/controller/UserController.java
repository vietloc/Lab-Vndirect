package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.ContextStartEventHandler;
import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/account")
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(ContextStartEventHandler.class));
    @Autowired private UserDAO userDAO;
    @Autowired private GroupDAO groupDAO;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView addForm(){
        ModelAndView mv = new ModelAndView("user.form","command", new User());
        mv.addObject("groups", toGroupMap(groupDAO.list()));
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView addNew(@Valid @ModelAttribute("command") User user, BindingResult result){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("user.form", "command",new User());
            mv.addObject("error", result);
            return mv;
        }
        LOGGER.info("add new user ------ >"+ user);
//        if (group.getId() > 0){
//            groupDAO.update(group);
//        } else {
//            groupDAO.insert(group);
//        }
        userDAO.insert(user);
        return new ModelAndView("redirect:/account/add");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "group", required = false)Integer group){
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users", userDAO.list(group));
//        mv.addObject("users", userDAO.listUserByNativeSQL());
//        mv.addObject("users", userDAO.page(1));
        //goi den listOlder tinh trung binh tuoi
        mv.addObject("average", userDAO.averageAge());
        return mv;
    }

    @RequestMapping(value = "/detail/{username}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable String username){
        ModelAndView mv = new ModelAndView("user.detail");
        mv.addObject("user", userDAO.get(username));
        return mv;
    }

    @RequestMapping(value = "/older", method = RequestMethod.GET)
    public ModelAndView listOlder(){
        ModelAndView mv = new ModelAndView("user.list");
        //goi den listOlder loc ra nhung ng tren 50 tuoi
        mv.addObject("users", userDAO.listOlder());
        return mv;
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
    public String delete(@PathVariable String name){
        userDAO.delete(name);
        return "redirect:/account/list";
    }

    @RequestMapping(value = "/adds")
    public String addRandom(){
        userDAO.addBatch();
        return "redirect:/account/list";
    }

    private Map<Integer, String> toGroupMap(List<Group> groups){
        Map<Integer, String> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getId(), group.getName()));
        return map;
    }


}
