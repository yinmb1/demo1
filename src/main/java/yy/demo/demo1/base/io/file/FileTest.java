package yy.demo.demo1.base.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author yinmb
 * @Date 2019/4/25 11:12:20
 */
public class FileTest {
    /**
     *  这个DEMO展示的跟File类相关的方法都是简单易懂的，其中有两个地方需要强调下：

     *  1、mkdirs是创建抽象名表示的文件或者目录，并且还会创建该目录或者文件的所有不存在的父目录。

     *  2、在16、17行，我这里用了两种不同的路径分割符来表示抽象路径，
     *  从运行结果来看都是可行的。那么两者有什么区别呢？

     *　　不同操作系统下文件分隔符：windows中是“\”，linux中是“/”，
     *    在用JAVA代码去读取windows系统中磁盘上的文件时候，若要用“\”，必须写成“\\”,
     *    因为一个"\"在java中表示是转义符。所以用“\\”代表“\”。在这里我的建议是尽量都写成“/”，
     *    因为在所有的操作系统中“/”永远都是没有问题的。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        File file = new File("e:/migu");
        file.mkdir();
        //判断该抽象名表示的目录是否存在
        if(file.exists() && file.isDirectory())
        {
            System.out.println("migu 目录存在");
            File file1 = new File("e:/migu/UES.txt");
            File file2 = new File("e:\\migu\\CMU.txt");
            //创建文件
            file1.createNewFile();
            file2.createNewFile();
            File file3 = new File("e:/migu/插件/支付中心");
            //创建此抽象名表示的目录，以及所有必需但是不存在的父目录
            file3.mkdirs();
            File[] files = file.listFiles();
            //该方法返回该路径下这一层的所有文件和目录
            for(File f : files)
            {
                System.out.println("migu目录下的文件名：" + f.getName());
                System.out.println("migu目录文件的绝对路径：" + f.getAbsolutePath());
            }
        }
        else
        {
            System.out.println("migu 目录不存在");
        }

    }
}
