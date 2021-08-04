package yy.demo.demo1.spi;

/**
 * @author yinmb
 * @date 2021/8/4 11:52
 */
public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl1");
    }
}
