package test.lj.com.mvpshopdemo.view;

import test.lj.com.mvpshopdemo.bean.ShopBean;

/**
 * Created by lj on 2017/11/21.
 */

public interface ShopView {

      public void  success(ShopBean bean);

       public void  failure(Exception e);

}
