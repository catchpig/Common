package conm.zhuazhu.common.utils;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Download {
    /**
     * 连接url
     */
    private String urlstr;
    /**
     * sd卡目录路径
     */
    private String sdcard;
    /**
     * http连接管理类
     */
    private HttpURLConnection urlcon;

    public Download(String url) {
        this.urlstr = url;
        //获取设备sd卡目录
        this.sdcard = Environment.getExternalStorageDirectory() + "/";
        urlcon = getConnection();
    }

    /*
     * 读取网络文本
     */
    public String downloadAsString() {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        try {
            InputStream is = urlcon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
        } catch (Exception e) {
            LogUtils.e(this.getClass().getName(), e.toString());
        }
        return sb.toString();
    }

    /*
     * 获取http连接处理类HttpURLConnection
     */
    private HttpURLConnection getConnection() {
        URL url;
        HttpURLConnection urlcon = null;
        try {
            url = new URL(urlstr);
            urlcon = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(this.getClass().getName(), e.toString());
        }
        return urlcon;
    }

    /*
     * 获取连接文件长度。
     */
    public int getLength() {
        return urlcon.getContentLength();
    }

    /*
     * 写文件到sd卡 demo
     * 前提需要设置模拟器sd卡容量，否则会引发EACCES异常
     * 先创建文件夹，在创建文件
     */
    public int down2sd(String dir, String filename, DownloadHandler handler) {
        StringBuilder sb = new StringBuilder(sdcard)
                .append(dir);
        File file = new File(sb.toString());
        boolean flag = false;
        if (!file.exists()) {
            flag = file.mkdirs();
            //创建文件夹
            //LogUtils.d("log", sb.toString());
        }
        //获取文件全名
        sb.append(filename);
        file = new File(sb.toString());

        FileOutputStream fos = null;
        try {
            InputStream is = urlcon.getInputStream();
            //创建文件
            flag = file.createNewFile();
            fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = is.read(buf)) != -1) {
                //fos.write(buf);
                fos.write(buf, 0, len);
                //同步更新数据
                handler.setSize(len);
            }
            is.close();
        } catch (Exception e) {
            LogUtils.e(this.getClass().getName(),"error:"+flag,e);
            return 0;
        } finally {
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                return 0;
            }
        }
        return 1;
    }

    /*
     * 内部回调接口类
     */
    public interface DownloadHandler {
        void setSize(int size);
    }
}
