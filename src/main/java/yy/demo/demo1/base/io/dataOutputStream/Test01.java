package yy.demo.demo1.base.io.dataOutputStream;

import java.io.*;

/**
 * 数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。
 * 然后，应用程序可以使用数据输入流将数据读入。
 * @author yinmb
 * @Date 2019/4/25 10:41:45
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("e:/data.txt")));
        byte b = 4;
        char c = 'c';
        int i = 12;
        float f = 3.3f;
        dos.writeByte(b);
        dos.writeChar(c);
        dos.writeInt(i);
        dos.writeFloat(f);
        dos.close();


        /**
         * 打开之后，里面是乱码，程序写入之后是一个二进制文件。
         * 我们的程序中是将java的基本数据类型写入文本，注意这里不是字符串，而是基本数据类型。
         * 我们这样写入是没有意义的，下面我们用同样的方式去读取。
         */

        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream("e:/data.txt")));
        System.out.println(dis.readByte());
        System.out.println(dis.readChar());
        System.out.println(dis.readInt());
        System.out.println(dis.readFloat());
        dis.close();


    }
    /**
     * 这里看到，我们的数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本JAVA数据类型。

     * 这里特别注意的地方是：读取数据类型的顺序与当初写入的数据类型的顺序要一致,否则会出现乱码或者读取的信息不准确。

     * 这个原因我们可以这样来理解：写入的时候是不同类型的基本数据，不同的基本数据类型的字节长度不一样，如果读取时候顺序不一致，会导致字节的组合混乱，导致乱码或者走义。
     */

}

