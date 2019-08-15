package yy.demo.demo1.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/4/22 19:45:52
 */
public class Tset01 {
    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("yy.demo.demo1.jvm.reference.StringTest");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
