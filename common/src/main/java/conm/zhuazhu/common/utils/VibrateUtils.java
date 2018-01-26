package conm.zhuazhu.common.utils;

import android.content.Context;
import android.os.Vibrator;

/**
 * 创建时间:2017/3/19 16:38
 * 创建人: 李涛
 * 修改人:李涛
 * 修改时间:2018年1月17日11:38:27
 * 描述:震动工具类
 */

public class VibrateUtils {
    /**
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param milliseconds The number of milliseconds to vibrate.
     */
    public static void vibrate(long milliseconds) {
        Vibrator vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milliseconds);
    }

    /**
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param pattern an array of longs of times for which to turn the vibrator on or off.
     * @param repeat  the index into pattern at which to repeat, or -1 if
     *                you don't want to repeat.
     */
    public static void vibrate(long[] pattern, int repeat) {
        Vibrator vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, repeat);
    }
}
