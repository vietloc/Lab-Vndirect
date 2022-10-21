package edu.java.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloClazzController {

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE,method = RequestMethod.POST)
    public ModelAndView printMessage(@RequestParam(value = "data", required = false)String message){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./clazz");
        mv.addObject("message", message);
        return mv;
    }

    //return ra html -  view-source
    public @ResponseBody String raw(){
        return  "Xin chao moi nguoi";
    }
    //den trang moom.vn
    public String redirect(){
        return "redirect:https://moom.vn";
    }
}
