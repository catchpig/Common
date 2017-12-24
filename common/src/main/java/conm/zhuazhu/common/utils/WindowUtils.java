package conm.zhuazhu.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;

/**
 * 创建时间:2017/3/27 17:53
 * 创建人: 李涛
 * 修改人:
 * 修改时间:
 * 描述:窗口工具类
 */

public class WindowUtils {
    /**
     * 获取meta-data的value
     * @param context
     * @param key
     * @return
     * @throws PackageManager.NameNotFoundException
     */
    public static String metaData(Context context, String key) throws
            PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = context.getPackageManager()
                .getApplicationInfo(context.getPackageName(), PackageManager
                        .GET_META_DATA);
        return applicationInfo.metaData.getString("key");
    }

    /**
     * 获取版本code
     *
     * @param context
     * @return
     * @throws Exception
     */
    public static int versionCode(Context context) throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(context
                .getPackageName(), 0);
        int version = packInfo.versionCode;
        return version;
    }

    /**
     * 获取版本
     *
     * @param context
     * @return
     * @throws Exception
     */
    public static String versionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName()
                    , 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (packInfo == null) {
            return null;
        }
        return packInfo.versionName;
    }

    /**
     * 获取设备id
     *
     * @return
     */
    public static String deviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService
                (Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 隐藏软键盘
     *
     * @param activity
     */
    public static void hiddenSoftInput(Activity activity) {
        InputMethodManager manager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(activity.getCurrentFocus()
                .getWindowToken(), 0);
    }
}
