package yy.demo.demo1.spring.aop.xml;

import org.springframework.stereotype.Service;

/**
 * @author yinmb
 * @Date 2019/5/22 15:30:39
 */
@Service
public class UserManagerServiceImpl implements IUserManagerService {
    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String findUser(){
        System.out.println("============执行业务方法findUser,查找的用户是："+name+"=============");
        return name;
    }

    public void addUser(){
        System.out.println("============执行业务方法addUser=============");
        //throw new RuntimeException();
    }
}
