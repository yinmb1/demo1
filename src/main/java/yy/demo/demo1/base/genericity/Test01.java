package yy.demo.demo1.base.genericity;

/**
 * 泛型类<T>
 * @author yinmb
 * @Date 2019/6/24 09:44:02
 */
public class Test01<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void add(T add){}

    /**
     * 泛型方法
     */
    public static < E > void printArray(E[] inputArray ) {
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
    }
}
