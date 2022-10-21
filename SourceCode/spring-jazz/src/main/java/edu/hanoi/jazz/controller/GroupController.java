package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.ContextStartEventHandler;
import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/group")
public class GroupController {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(ContextStartEventHandler.class));

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addForm(){
        return new ModelAndView("group.form", "command",new Group());
    }

    @Autowired private GroupDAO groupDAO;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("group.form", "command",group);
            model.addObject("error", result);
            return model;
        }
        LOGGER.info("add new group ------ >"+group);
        if (group.getId() > 0){
            groupDAO.update(group);
        } else {
            groupDAO.insert(group);
        }
        return new ModelAndView("redirect:/group/list");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "q", required = false)String pattern){
        ModelAndView mv = new ModelAndView("group.list");
        mv.addObject("groups", groupDAO.list(pattern));
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        if(id == null){
            return new ModelAndView("redirect:/group/list");
        }
        groupDAO.delete(id);
        return new ModelAndView("redirect:/group/list");
    }

    @RequestMapping(value = "/edit")
    public ModelAndView updateForm(@RequestParam(value = "id", required = true)Integer id){
        Group group = groupDAO.get(id);
        if(group == null){
            return new ModelAndView("redirect:/group/list");
        }
        return new ModelAndView("group.form","command", group);
    }
}
