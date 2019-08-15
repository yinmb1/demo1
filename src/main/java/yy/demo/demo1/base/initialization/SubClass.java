package yy.demo.demo1.base.initialization;

/**
 * 对于静态字段，只有直接定义这个字段的类才会被初始化，
 * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
 * 在本例中，由于value字段是在类SClass中定义的，因此该类会被初始化；此外，在初始化类SClass时,
 * 虚拟机会发现其父类SSClass还未被初始化，因此虚拟机将先初始化父类SSClass
 * 然后初始化子类SClass，而SubClass始终不会被初始化。
 * @author yinmb
 * @Date 2019/4/23 16:09:20
 */
public  class SubClass extends SClass{
    static{
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass(){
        System.out.println("init SubClass");
    }

    public static void main(String[] args) {



    }
}
