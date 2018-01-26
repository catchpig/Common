package com.zhuazhu;

import android.app.Application;

import conm.zhuazhu.common.utils.Utils;

/**
 * 创建时间:2018-01-26 16:16<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2018-01-26 16:16<br/>
 * 描述:
 */

public class CApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
