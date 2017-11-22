package com.qizu.yuekaocar.presenter;

import com.qizu.yuekaocar.bean.ShopBean;
import com.qizu.yuekaocar.model.MainModel;
import com.qizu.yuekaocar.model.MainModelCallBack;
import com.qizu.yuekaocar.view.MainViewListener;

/**
 * Created by jiuhao on 2017/11/21.
 * data 2017/11/21
 * time 下午 04:29
 */

public class MainPresenter {
    private MainViewListener listener;
    private MainModel mainModel;
    public  MainPresenter(MainViewListener listener){
        this.listener = listener;
        this.mainModel = new MainModel();
    }
    public void getData(){
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                if(listener != null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {
                if(listener != null){
                    listener.failure(e);
                }
            }
        });
    }
    //防止內存泄露
    public void detach(){
        listener = null;
    }
}
