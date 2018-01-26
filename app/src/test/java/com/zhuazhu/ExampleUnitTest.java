package com.zhuazhu;

import org.junit.Test;

import conm.zhuazhu.common.utils.EncryptUtils;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test(){
        String m5 = EncryptUtils.encryptMD5ToString("123456");

        System.out.println(m5);
    }
}