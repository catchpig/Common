package conm.zhuazhu.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 创建时间:2017/3/19 15:56
 * 创建人: 李涛
 * 修改人:
 * 修改时间:
 * 描述:屏幕工具类
 */

public class ScreenUtils {
    private ScreenUtils() {
        throw new AssertionError();
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return (px)
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return (px)
     */
    public static int getScreenHeigt(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * dp转px
     * @param dp
     * @return
     */
    public static float dpToPx(float dp) {
        return dp * Utils.getApp().getResources().getDisplayMetrics().density;
    }

    /**
     * px转dp
     * @param px
     * @return
     */

    public static float pxToDp(float px) {
        return px / Utils.getApp().getResources().getDisplayMetrics().density;
    }

    /**
     * dp转px
     * @param dp
     * @return 返回int类型
     */
    public static int dpToPxInt(float dp) {
        return (int)(dpToPx( dp) + 0.5f);
    }

    /**
     * px转dp
     * @param px
     * @return 返回int类型
     */
    public static int pxToDpCeilInt(float px) {
        return (int)(pxToDp(px) + 0.5f);
    }
}
