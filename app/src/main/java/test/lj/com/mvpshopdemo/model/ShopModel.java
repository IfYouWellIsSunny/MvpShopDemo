package test.lj.com.mvpshopdemo.model;

import test.lj.com.mvpshopdemo.bean.ShopBean;
import test.lj.com.mvpshopdemo.okhttp.AbstractUiCallBack;
import test.lj.com.mvpshopdemo.okhttp.OkhttpUtils;

/**
 * Created by lj on 2017/11/21.
 */

public class ShopModel {

         public  void  getData(final ModelCallBack callBack){
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
