package com.yx.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class [] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)
        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result: "+result);
        System.out.println(dao.update("我要变强"));
    }
}
class UserDaoProxy implements InvocationHandler{
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行...."+method.getName()+" :传递的参数..."+ Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println(res);
        System.out.println("方法之后执行..."+obj);
        return res;
    }
}
