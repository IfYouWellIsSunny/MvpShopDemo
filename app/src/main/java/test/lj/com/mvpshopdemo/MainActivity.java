package test.lj.com.mvpshopdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.lj.com.mvpshopdemo.bean.ShopBean;
import test.lj.com.mvpshopdemo.presenter.ShopPresenter;
import test.lj.com.mvpshopdemo.view.ShopView;

public class MainActivity extends Activity implements ShopView {

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox checkBoxAll;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private ShopPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new ShopPresenter(this);
        presenter.getData();
        adapter = new ShopAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        //回调让总价和件数显示在页面
        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                checkBoxAll.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);

            }
        });
    }


    @Override
    public void success(ShopBean bean) {

        adapter.add(bean);
    }

    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    //全选
    @OnClick(R.id.third_allselect)
    public void onViewClicked() {

        adapter.selectAll(checkBoxAll.isChecked());
    }


}
