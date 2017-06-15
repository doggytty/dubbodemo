package org.doggytty.controllers;

import org.doggytty.services.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by doggy on 17-6-15.
 */
@Controller
@RequestMapping("/dubbo")
public class DubboControllers {

    @Autowired
    private IDemoService demoService;

    @RequestMapping("/api")
    @ResponseBody
    public String invokeDubbo() {
        String helloString = demoService.sayHello("doggytty");
        return helloString;
    }
}
