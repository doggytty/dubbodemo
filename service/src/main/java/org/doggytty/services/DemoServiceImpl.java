package org.doggytty.services;

/**
 * Created by doggy on 17-6-14.
 */
public class DemoServiceImpl implements IDemoService {

    public String sayHello(String name) {
        return String.format("hello, %s", name);
    }
}
