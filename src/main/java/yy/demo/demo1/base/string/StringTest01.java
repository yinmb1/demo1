package yy.demo.demo1.base.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/8/9 15:51:29
 */
public class StringTest01 {
    public static void main(String[] args){
//        String str = "Java interview";
//
//
//        //string to char array
//       char[] chars = str.toCharArray();
//        System.out.println(chars.length);
//        for (int i = 0; i <chars.length-1 ; i++) {
//            System.out.println(chars[i]);
//        }
//        String str2 =new String(chars);
//        System.out.println(str2);

        byte[] byteArray = { 'P', 'A', 'N', 'K', 'A', 'J' };
        byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };

        String str = new String(byteArray);
        String str1 = new String(byteArray1);

        System.out.println(str);
        System.out.println(str1.substring(1));
        System.out.println(str1.charAt(1));

        str.contains("321");

        char[] array = str.toCharArray();
        List<String> resultList = new ArrayList<>(array.length);
        resultList.forEach(s -> {
            System.out.println(s);
        });
    }

}
