package conm.zhuazhu.common.utils;

import android.content.Context;
import android.os.Vibrator;

/**
 * 创建时间:2017/3/19 16:38
 * 创建人: 李涛
 * 修改人:
 * 修改时间:
 * 描述:震动工具类
 */

public class VibrateUtils {
    /**
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param context
     * @param milliseconds The number of milliseconds to vibrate.
     */
    public static void vibrate(Context context, long milliseconds) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milliseconds);
    }

    /**
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param context
     * @param pattern an array of longs of times for which to turn the vibrator on or off.
     * @param repeat  the index into pattern at which to repeat, or -1 if
     *                you don't want to repeat.
     */
    public static void vibrate(Context context, long[] pattern, int repeat) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, repeat);
    }
}
