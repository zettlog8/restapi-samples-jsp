package com.treehub.restapi.samples.jsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class JspMainController {
    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
    
}
