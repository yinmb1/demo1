package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 11:47:54
 */
class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);
        int x = getValue();
        System.out.println("x"+x);
    }

    {
        i = 2;
    }

    protected int getValue() {
        System.out.println("getValue"+i);
        return i;
    }
}
class Bar extends Foo {
    int j = 1;

    Bar() {
        j = 2;
    }

    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }

    public static void main(String... args) {
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }

}

