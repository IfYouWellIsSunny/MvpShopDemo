package test.lj.com.mvpshopdemo.model;

import test.lj.com.mvpshopdemo.bean.ShopBean;

/**
 * Created by lj on 2017/11/21.
 */

public interface ModelCallBack {

      public  void success(ShopBean bean);
       public  void  failure(Exception e);

}
