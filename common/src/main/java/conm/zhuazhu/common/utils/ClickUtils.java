package conm.zhuazhu.common.utils;

/**
 * 创建时间:2017/5/12 17:49<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/5/12 17:49<br/>
 * 描述:点击事件工具
 */

public class ClickUtils {
    /**
     * 默认休眠时间
     */
    private static final long DEFAULT_SLEEP_TIME = 1000;
    /**
     * 最后点击时间
     */
    private static long lastClickTime;

    /**
     * 是否是快速点击
     * @return
     */
    public synchronized static boolean isFastClick(){
        long time = System.currentTimeMillis();
        if ( time - lastClickTime < DEFAULT_SLEEP_TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 是否是快速点击
     * @param sleep 睡眠时间
     * @return
     */
    public synchronized static boolean isFastClick(long sleep){
        long time = System.currentTimeMillis();
        if ( time - lastClickTime < sleep) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
