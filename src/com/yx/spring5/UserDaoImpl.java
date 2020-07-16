package com.yx.spring5;

//（2）创建接口实现类，实现方法
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add方法正在执行");
        return a+b;
    }
    @Override
    public String update(String id) {
        System.out.println("update方法正在执行");
        return id;
    }
}

