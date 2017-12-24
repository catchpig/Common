package conm.zhuazhu.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;

/**
 * Created by tao on 2015/9/30.
 */
public class CommonUtils {

    /***
     * 对象序列化
     *
     * @param obj
     * @return 可能为null
     * @throws IOException
     */
    public static byte[] objectToByte(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        byte[] by = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            by = baos.toByteArray();
        } catch (IOException e) {
            return by;
        } finally {
            try {
                if(oos!=null){
                    oos.close();
                }
                if(baos!=null){
                    baos.close();
                }
            } catch (IOException e) {
                return by;
            }
        }

        return by;
    }

    /***
     * 反序列化
     *
     * @param by
     * @return 可能为null
     */
    public static <T> T getObjectFromByte(byte[] by, T t) {
        ByteArrayInputStream bais = new ByteArrayInputStream(by);
        ObjectInputStream oos = null;
        T obj = null;
        try {
            oos = new ObjectInputStream(bais);
            obj = (T) oos.readObject();
        } catch (Exception e) {
        } finally {
            try {
                if(oos!=null){
                    oos.close();
                }
                if(bais!=null){
                    bais.close();
                }
            } catch (IOException e) {
            }
        }

        return obj;
    }

    /***
     * Base64加密
     */
    public static String getBase64Code(String param) {
        return URLEncoder.encode(param);
    }






}
