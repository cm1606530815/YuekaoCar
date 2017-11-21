package com.qizu.yuekaocar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qizu.yuekaocar.bean.ShopBean;
import com.qizu.yuekaocar.presenter.MainPresenter;
import com.qizu.yuekaocar.view.MainViewListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainViewListener {

    @BindView(R.id.third_recyclerView)
    RecyclerView thirdRecyclerView;
    @BindView(R.id.third_allSelect)
    CheckBox thirdAllSelect;
    @BindView(R.id.third_totalPrice)
    TextView thirdTotalPrice;
    @BindView(R.id.third_totalNum)
    TextView thirdTotalNum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MainPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.getData();

        adapter = new ShopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        thirdRecyclerView.setLayoutManager(manager);
        thirdRecyclerView.setAdapter(adapter);
        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllSelect.setChecked(allCheck);
                thirdTotalNum.setText(num);
                thirdTotalPrice.setText(total);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allSelect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllSelect.isChecked());
    }
}
