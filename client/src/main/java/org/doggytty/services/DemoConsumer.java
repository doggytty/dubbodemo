package org.doggytty.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by doggy on 17-6-15.
 */
public class DemoConsumer {

    private static Logger logger = LoggerFactory.getLogger(DemoConsumer.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        IDemoService demoService = (IDemoService) ctx.getBean("demoService");
        logger.info("执行结果：" + demoService.sayHello("hello"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
