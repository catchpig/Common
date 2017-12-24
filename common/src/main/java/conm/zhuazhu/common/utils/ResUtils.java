package conm.zhuazhu.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

/**
 * 创建时间:2017/5/5 18:04<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * @version 1.0.0
 * 修改时间: 2017/5/5 18:04<br/>
 * 描述:资源数据工具类
 */

public class ResUtils {
    /**
     * 获取资源(strings.xml)字符串
     * @param context
     * @param id
     * @return
     */
    public static String string(@NonNull Context context, @StringRes int id){
        return context.getResources().getString(id);
    }

    /**
     * 获取资源Drawable
     * @param context
     * @param drawable
     * @return
     */
    public static Drawable drawable(@NonNull Context context, @DrawableRes int drawable){
        return ContextCompat.getDrawable(context, drawable);
    }

    /**
     * 获取资源颜色(colors.xml)的ColorInt
     * @param context
     * @param color
     * @return
     */
    @ColorInt
    public static int color(@NonNull Context context, @ColorRes int color){
        return ContextCompat.getColor(context,color);
    }
}
