package org.doggytty.services;

import org.springframework.stereotype.Service;

/**
 * Created by doggy on 17-6-14.
 */
@Service("demoService")
public class DemoServiceImpl implements IDemoService {

    public String sayHello(String name) {
        return String.format("hello, %s", name);
    }
}
