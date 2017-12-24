package conm.zhuazhu.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * 验证请求地址是否是自带http或者https
     *
     * @param url web地址
     * @return
     */
    public static boolean validateHttpOrHttps(String url) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }
        return url.length() > 4 && ("http".equals(url.substring(0, 4)) || "https".equals(url
                .substring(0, 5)));
    }


    /**
     * 转换为12的金额
     *
     * @param money
     * @return
     */
    public static String convert12Money(String money) {
        //12位的金钱(后两位表示角和分)
        StringBuffer rmb = new StringBuffer();
        if (money.indexOf(".") != -1) {//有小数
            String[] ms = money.split("\\.");
            for (int i = 0; i < 10 - ms[0].length(); i++) {
                rmb.append("0");
            }
            rmb.append(ms[0]);
            if (ms[1].length() > 2) {
                rmb.append(ms[1].substring(0, 2));
            } else {
                rmb.append(ms[1]);
                for (int i = 0; i < 2 - ms[1].length(); i++) {
                    rmb.append("0");
                }
            }
        } else {//没有小数
            for (int i = 0; i < 10 - money.length(); i++) {
                rmb.append("0");
            }
            rmb.append(money);
            rmb.append("00");
        }
        return rmb.toString();
    }

    /**
     * 验证是否包含非法字符
     *
     * @param str
     * @return
     */
    public static boolean validateIllegalChar(String str) {
        String c = "^[a-z0-9A-Z\\u4e00-\\u9fa5][-(),.?，。？a-z0-9A-Z\\u4e00-\\u9fa5]*$";
        return !str.matches(c);
    }

    /**
     * 验证不是车牌号码
     *
     * @param plate
     * @return
     */
    public static boolean validateNotPlateNumber(String plate) {
        return !validatePlateNumber(plate);
    }

    /**
     * 验证车牌号
     *
     * @param plate
     * @return
     */
    public static boolean validatePlateNumber(String plate) {
        Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$");
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    /**
     * 验证不是数字
     *
     * @param number
     * @return
     */
    public static boolean validateNotNumber(String number) {
        return validateNumber(number);
    }

    /**
     * 验证数字
     *
     * @param number
     * @return
     */
    public static boolean validateNumber(String number) {
        if(number.indexOf(".")!=-1){
            //小数
            return number.matches("^[-+]?\\d+(.)\\d*$");
        }else{
            //整数
            return number.matches("^[-+]?\\d+$");
        }
    }

    /**
     * 验证不是身份证号
     *
     * @param identity
     * @return
     */
    public static boolean validateNotIdentity(String identity) {
        return !validateIdentity(identity);
    }

    /**
     * 验证身份证号
     *
     * @param identity
     * @return
     */
    public static boolean validateIdentity(String identity) {
        boolean flag = false;
        int length = identity.length();
        if (length == 15 || length == 18) {
            Pattern p;
            if (length == 15) {//15位身份证号
                p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
            } else {//18位身份证号
                p = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)" +
                        "|3[0-1])\\d{3}([0-9]|x|X)$");
            }
            //通过Pattern获得Matcher
            Matcher matcher = p.matcher(identity);
            flag = matcher.matches();
        }
        return flag;
    }

    /**
     * 格式化数字字符串为4位隔开显示
     *
     * @param cardNumber
     * @return
     */
    public static String formatCardNumber(String cardNumber) {
        int len = cardNumber.length() / 4;
        StringBuffer buffer = new StringBuffer(cardNumber);
        for (int i = len; i > 0; i--) {
            buffer.insert(4 * i, " ");
        }
        return buffer.toString();
    }

    /**
     * 格式化小数位数
     *
     * @param obj   数字,数字字符串<br/>
     *              <li>String</li>
     *              <li>Double</li>
     *              <li>Long</li>
     *              <li>Integer</li>
     *              <li>Float</li>
     *              <li>BigDecimal</li>
     *              <li>BigInteger</li>
     * @param scale 小数位数
     * @param mode  格式化方式
     * @return
     */
    public static String format(Object obj, int scale, RoundingMode mode) {
        if (obj == null) {
            obj = 0;

        } else if (obj instanceof String) {
            if (validateNumber(obj.toString())) {
                obj = new BigDecimal(obj.toString()).doubleValue();
            } else {
                obj = 0;
            }
        }
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < scale; i++) {
            buffer.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0." + buffer.toString());
        decimalFormat.setRoundingMode(mode);
        return decimalFormat.format(obj);
    }

    /**
     * 格式化小数位数
     *
     * @param obj   数字,数字字符串
     * @param scale 小数位数
     * @return
     */
    public static String format(Object obj, int scale) {
        return format(obj, scale, RoundingMode.DOWN);
    }

    /**
     * 格式化金额为两位小数,不足两位小数的补0
     *
     * @param obj
     * @return
     */
    public static String money(Object obj) {
        return format(obj, 2);
    }

    /**
     * 验证字符串是否为空
     *
     * @param strs
     * @return 只要有一个为空, 就返回true
     */
    public static boolean isEmpty(String... strs) {
        for (String s : strs) {
            boolean flag = isEmpty(s);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        boolean flag = true;
        flag = (str == null || "".equals(str.trim()));
        return flag;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 验证不是手机号码
     *
     * @param phone
     * @return
     */
    public static boolean vilidateNotPhone(String phone) {
        return !validatePhone(phone);
    }

    /**
     * 验证手机号
     *
     * @param phone
     * @return
     */
    public static boolean validatePhone(String phone) {
        boolean flag = false;
        if (phone == null || "".equals(phone.trim()) || phone.length() != 11 || !(phone.substring
                (0, 1)).equals("1")) {
            flag = false;
        } else {
            Pattern p = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
            flag = p.matcher(phone).matches();
        }
        return flag;
    }
}
