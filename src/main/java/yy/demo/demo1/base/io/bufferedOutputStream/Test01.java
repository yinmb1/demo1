package yy.demo.demo1.base.io.bufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 在前面介绍的FileOutputStream，是在程序里面读取一个字节，
 * 就往外写一个字节。在这种情况下，频繁的跟IO设备打交道，
 * I/O的处理速度跟CPU的速度根本就不在一个量级上(I/O是一种物理设备)，
 * 在信息量很多的时候，就比较消耗性能。基于这种问题，JAVA提供了缓冲字节流，
 * 通过这种流，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。
 * @author yinmb
 * @Date 2019/4/25 10:33:28
 */
public class Test01
{

    public static void main(String[] args) throws IOException
    {
        OutputStream os = new FileOutputStream("D:/test.txt");
        OutputStream bs = new BufferedOutputStream(os);
        byte[] buffer = "中国移动阅读基地".getBytes();
        bs.write(buffer);
        bs.close();
        os.close();
    }

    /**
     *     缓冲输出流在输出的时候，不是直接一个字节一个字节的操作，
     *     而是先写入内存的缓冲区内。直到缓冲区满了或者我们调用close方法或flush方法，
     *     该缓冲区的内容才会写入目标。才会从内存中转移到磁盘上。
     *     下面来看看不调用close方法会出现什么情况：
     *
     *     在这里没有调用close方法，相当于内容还在内存的缓冲区中。
     *     BufferedOutputStream本身没有close方法，
     *     调用的是父类FilterOutputStream的close方法：
     *
     *     在这里可以看到这个方法的本质是在在关闭资源之前，调用的flush方法。
     *     而flush在JDK中的定义为：刷新此缓冲的输出流。
     *     这迫使所有缓冲的输出字节被写出到底层输出流中
     */
}
