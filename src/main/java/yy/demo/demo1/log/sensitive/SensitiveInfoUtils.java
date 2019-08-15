package yy.demo.demo1.log.sensitive;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 脱敏处理工具类
 *
 * @author yinmb
 * @Date 2019/7/4 16:18:24
 */
public class SensitiveInfoUtils {

    /**
     * [姓名] 只显示第一个汉字，其他隐藏为星号<例子：李**>
     *
     * @param fullName
     * @return
     */
    public static String chineseName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * [姓名] 第二个字脱敏<例子：李*贵>
     *
     * @param fullName
     * @return
     */
    public static String chineseName2(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        if(fullName.length()>=2){
            StringBuilder sb = new StringBuilder(fullName);
            fullName = sb.replace(1, 1, "*").toString();
        }
        return fullName;
    }

    /**
     * [身份证号] 显示最后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
     *
     * @param idCardNum
     * @return
     */
    public static String idCardNum(String idCardNum) {
        if (StringUtils.isBlank(idCardNum)) {
            return "";
        }
        String num = StringUtils.right(idCardNum, 4);
        return StringUtils.leftPad(num, StringUtils.length(idCardNum), "*");
    }

    /**
     * [固定电话] 后四位，其他隐藏<例子：****1234>
     *
     * @param num
     * @return
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*");
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138****1234>
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(
                StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    /**
     * [银行卡号] 前六位，后四位，其他用星号隐藏每位1个星号<例子:6222600**********1234>
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }


    /**
     * [电子邮箱] 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示<例子:g****@163.com>
     *
     * @param email
     * @return
     */
    public static String emailFirstChar(String email){
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) return email;
        else
        return StringUtils.rightPad(StringUtils.left(email,1),index,"*").concat(StringUtils.mid(email,index, StringUtils.length(email)));
    }

    /**
     * [电子邮箱] 邮箱@符号之前保留四位，其他隐藏，用星号代替，@及后面的地址显示<例子:****1234@163.com>
     *
     * @param email
     * @return
     */
    public static String emailEndChar(String email) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 4) {
            return email;
        } else {
            String str = StringUtils.substring(email,0,index);
            return StringUtils.leftPad(StringUtils.right(str, 4), index, "*").concat(StringUtils.mid(email, index, StringUtils.length(email)));
        }
    }

    /**
     * 验证是否是手机号码
     *
     * @param str
     * @return
     */
    public static boolean isPhone(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(1[3,4,5,7,8][0-9])\\d{8}$");
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }
}