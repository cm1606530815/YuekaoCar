package com.qizu.yuekaocar.view;

import com.qizu.yuekaocar.bean.ShopBean;

/**
 * Created by jiuhao on 2017/11/21.
 * data 2017/11/21
 * time 下午 04:30
 */

public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
