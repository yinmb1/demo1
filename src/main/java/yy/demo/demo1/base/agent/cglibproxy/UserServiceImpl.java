package yy.demo.demo1.base.agent.cglibproxy;

/**
 * @author yinmb
 * @Date 2019/5/24 16:07:38
 */
public class UserServiceImpl implements IUserService{

    public void addUser(){
        System.out.println("新增了一个用户！");
    }

    public void deleteUser(){
        System.out.println("删除了一个用户！");
    }
}