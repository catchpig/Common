package conm.zhuazhu.common.utils;

/**
 * Created by tao on 2016/11/23.
 */

public class LogUtils {
    private static boolean DEBUG = false;

    /**
     * 设置日志在debug模式才显示
     * @param debug
     */
    public static void setDebug(boolean debug){
        DEBUG = debug;
    }
    public static void e(String tag,String msg){
        if(DEBUG){
            android.util.Log.e(tag,msg);
        }
    }
    public static void e(String tag,String msg,Throwable t){
        if(DEBUG){
            android.util.Log.e(tag,msg,t);
        }
    }
    public static void i(String tag,String msg){
        if(DEBUG){
            android.util.Log.i(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if(DEBUG){
            android.util.Log.d(tag,msg);
        }
    }
    public static void w(String tag,String msg){
        if(DEBUG){
            android.util.Log.w(tag,msg);
        }
    }
    public static void w(String tag,Throwable e){
        if(DEBUG){
            android.util.Log.w(tag,e);
        }
    }
    public static void w(String tag,String msg,Throwable e){
        if(DEBUG){
            android.util.Log.w(tag,msg,e);
        }
    }
}
