package conm.zhuazhu.common.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

/**
 * 创建时间:2017/3/27 17:53
 * 创建人: 李涛
 * 修改人:
 * 修改时间:
 * 描述:窗口工具类
 */

public class WindowUtils {

    /**
     * 获取设备id
     *
     * @return
     * 返回为null,代表没有开启READ_PHONE_STATE权限
     */
    public static String deviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService
                (Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        return tm.getDeviceId();
    }
}
