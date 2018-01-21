package conm.zhuazhu.common.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 创建时间:2018/1/17 11:43<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2018/1/17 11:43<br/>
 * 描述:
 */

public interface MemoryConstants {
    /**
     * Byte 与 Byte 的倍数
     */
    int BYTE = 1;
    /**
     * KB 与 Byte 的倍数
     */
    int KB   = 1024;
    /**
     * MB 与 Byte 的倍数
     */
    int MB   = 1048576;
    /**
     * GB 与 Byte 的倍数
     */
    int GB   = 1073741824;

    @IntDef({BYTE, KB, MB, GB})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
