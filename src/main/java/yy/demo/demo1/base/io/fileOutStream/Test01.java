package yy.demo.demo1.base.io.fileOutStream;

import java.io.*;

/**
 * @author yinmb
 * @Date 2019/4/25 09:20:56
 */
public class Test01 {
    public static void main(String[] args) throws IOException
    {
        InputStream fis =null;
        try {
            fis = new FileInputStream("e:/test1.txt");
            InputStreamReader reader = new InputStreamReader(fis,"UTF-8"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
