/*
 * 文 件 名:  MD5SignUtil.java
 * 版    权:  四川嘉信商运物业服务有限公司,  All rights reserved
 * 描    述:  描述
 * 创    建  人:  admin
 * 修   改  人：
 * 修改时间:  2015年8月25日
 * 修改内容:  修改内容
 */
package conm.zhuazhu.common.utils;

import android.annotation.SuppressLint;

import java.security.MessageDigest;

/**
 * MD5签名/加密工具
 *
 * @author admin
 * @version 0.0.1
 * @date 2015年8月25日
 * @see [相关类/方法]
 */
@SuppressLint("DefaultLocale")
public class MD5Utils {
    /**
     * MD5加密算法
     *
     * @param s
     * @return
     * @see [类、类#方法、类#成员]
     */
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes("UTF-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
