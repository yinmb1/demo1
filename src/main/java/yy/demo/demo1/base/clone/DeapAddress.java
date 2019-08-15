package yy.demo.demo1.base.clone;

import org.springframework.beans.BeanUtils;

/**
 * @author yinmb
 * @Date 2019/6/24 14:34:32
 */
public class DeapAddress implements Cloneable {
    private String add;
    public String getAdd() {
        return add;
    }
    public void setAdd(String add) {
        this.add = add;
    }
    @Override
    public Object clone() {
        DeapAddress addr = null;
        try{
            addr = (DeapAddress)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr;
    }
}

class Student01 implements Cloneable{
    private int number;

    private DeapAddress addr;

    @Override
    public Object clone() {
        Student01 stu = null;
        try{
            //浅复制
            stu = (Student01)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //深度复制
        stu.addr = (DeapAddress)addr.clone();
        return stu;
    }
    public DeapAddress getAddr() {
        return addr;
    }

    public void setAddr(DeapAddress addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
 class Test01 {

    public static void main(String args[]) {

        DeapAddress addr = new DeapAddress();
        addr.setAdd("杭州市");
        Student01 stu1 = new Student01();
        stu1.setNumber(123);
        stu1.setAddr(addr);

        Student01 stu2 = (Student01)stu1.clone();

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

        addr.setAdd("西湖区");

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());


    }
}
class Test02 {

    public static void main(String args[]) {
        DeapAddress addr = new DeapAddress();
        addr.setAdd("杭州市");

        Student01 stu1 = new Student01();
        stu1.setNumber(12345);
        stu1.setAddr(addr);
        Student01 stu2 = new Student01();
        BeanUtils.copyProperties(stu1,stu2);



        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());


        DeapAddress addr1 = new DeapAddress();
        addr1.setAdd("西湖区");
        stu2.setNumber(123);

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());


    }


}

