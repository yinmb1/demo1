package yy.demo.demo1.base.io.fileOutStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 1、这个DEMO主要是将字符串写入磁盘文件中。
 * 2、在第3行的构造函数处要注意下，这个方法中如果指定的文件不存在，则会创建一个新的；
 *     如果指定的文件存在，在后面的写入操作会覆盖原有的内容。
 * @author yinmb
 * @Date 2019/4/25 09:45:18
 */
public class Test02 {
    public static void main(String[] args) throws IOException
    {
        OutputStream os = new FileOutputStream("e:/test1.txt");
        String str = "中国移动手机阅读";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();
    }
}
