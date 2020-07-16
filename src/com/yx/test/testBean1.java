package com.yx.test;

import com.yx.aopxml.Book;
import com.yx.apoanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean1 {
    @Test
    public void testAopAnno(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        User user = context.getBean("user",User.class);
        user.add();
    }

    @Test
    public void testAopXml(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book",Book.class);
        book.buy();

    }
}
