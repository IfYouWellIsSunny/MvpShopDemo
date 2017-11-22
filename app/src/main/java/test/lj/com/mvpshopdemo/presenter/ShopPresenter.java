package test.lj.com.mvpshopdemo.presenter;

import test.lj.com.mvpshopdemo.bean.ShopBean;
import test.lj.com.mvpshopdemo.model.ModelCallBack;
import test.lj.com.mvpshopdemo.model.ShopModel;
import test.lj.com.mvpshopdemo.view.ShopView;

/**
 * Created by lj on 2017/11/21.
 */

public class ShopPresenter {

    private ShopView listener;
    private ShopModel mainModel;
    public ShopPresenter(ShopView listener) {
        this.listener = listener;
        this.mainModel=new ShopModel();
    }

    public void getData(){

         mainModel.getData(new ModelCallBack() {
             @Override
             public void success(ShopBean bean) {

                 if (listener!=null){
                     listener.success(bean);
                 }

             }

             @Override
             public void failure(Exception e) {
                 if (listener!=null){
                     listener.failure(e);
                 }

             }
         });

    }

    /**
     * 防止内存泄漏
     */
    public void detach(){
        listener = null;
    }


}
