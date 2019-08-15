package yy.demo.demo1.base.clone;

/**
 * 浅克隆
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；
 * 如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，
 * 也就是说原型对象和克隆对象的成员变量指向相同的内存地址。
 * @author yinmb
 * @Date 2019/6/24 14:25:23
 */
public class Address {

        private String add;

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
    }

    class Student implements Cloneable{
        private int number;

        private Address addr;

        public Address getAddr() {
            return addr;
        }

        public void setAddr(Address addr) {
            this.addr = addr;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public Object clone() {
            Student stu = null;
            try{
                stu = (Student)super.clone();   //浅复制
            }catch(CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return stu;
        }
    }
     class Test {

        public static void main(String args[]) {

            Address addr = new Address();
            addr.setAdd("杭州市");
            Student stu1 = new Student();
            stu1.setNumber(123);
            stu1.setAddr(addr);

            Student stu2 = (Student)stu1.clone();

            System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
            System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

            addr.setAdd("西湖区");
            stu2.setNumber(234);
            System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
            System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
        }


//         学生1:123,地址:杭州市
//         学生2:123,地址:杭州市
//         学生1:123,地址:西湖区
//         学生2:234,地址:西湖区
//         怎么两个学生的地址都改变了？
//
//         原因是浅复制只是复制了addr变量的引用，并没有真正的开辟另一块空间，将值复制后再将引用返回给新对象。

}
