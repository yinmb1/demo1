package yy.demo.demo1.base.io.fileOutStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 如果我不想覆盖原有的内容，只想在后面追加内容呢
 * @author yinmb
 * @Date 2019/4/25 10:08:50
 */
public class Test03 {
    public static void main(String[] args) throws IOException
    {
        OutputStream os = new FileOutputStream("e:/test1.txt",true);
        String str = "注册用户6亿";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();
    }
}
