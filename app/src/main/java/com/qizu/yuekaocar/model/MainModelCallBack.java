package com.qizu.yuekaocar.model;

import com.qizu.yuekaocar.bean.ShopBean;

/**
 * Created by jiuhao on 2017/11/21.
 * data 2017/11/21
 * time 下午 04:22
 */

public interface MainModelCallBack {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
