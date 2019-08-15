package yy.demo.demo1.modes.builder;

/**
 * @author yinmb
 * @Date 2019/1/24 15:46:48
 */
public abstract class Builder {
    private Computer pc ;
    public abstract void buildCpu();
    public abstract void buildRam();
    public abstract void buildMonitor();


    public void createComputer(){
        this.pc = new Computer();
    }
    public Computer getComputer(){
        return this.pc;
    }
}
