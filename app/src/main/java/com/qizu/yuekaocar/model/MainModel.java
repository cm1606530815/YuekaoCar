package com.qizu.yuekaocar.model;

import com.qizu.yuekaocar.bean.ShopBean;
import com.qizu.yuekaocar.okhttp.AbstractUiCallBack;
import com.qizu.yuekaocar.okhttp.OkhttpUtils;

/**
 * Created by jiuhao on 2017/11/21.
 * data 2017/11/21
 * time 下午 04:20
 */

public class MainModel {
    public  void getData(final MainModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {
                    callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {
                    callBack.failure(e);
            }
        });
    }
}
