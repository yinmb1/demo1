package yy.demo.demo1.modes.bridge;

/**
 * @author yinmb
 * @Date 2019/1/30 10:12:24
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
