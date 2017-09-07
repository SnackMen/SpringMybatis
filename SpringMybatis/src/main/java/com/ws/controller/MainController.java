package com.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        logger.debug("访问/login方法");
        return "login";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg(){
        logger.debug("访问/login方法");
        return "register";
    }

}
