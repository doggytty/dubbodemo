package org.doggytty.controllers;

import org.doggytty.services.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by doggy on 17-6-15.
 */
@Controller
@RequestMapping(value="/dubbo")
public class DubboControllers {

    @Qualifier
    private IDemoService demoService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/api")
    public String invokeDubbo() {
        String helloString = demoService.sayHello("doggytty");
        return helloString;
    }
}
