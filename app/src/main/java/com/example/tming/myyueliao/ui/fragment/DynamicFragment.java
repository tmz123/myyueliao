package com.example.tming.myyueliao.ui.fragment;

import android.widget.Button;
import android.widget.TextView;

import com.example.tming.myyueliao.R;
import com.example.tming.myyueliao.presenter.DynamicPresenter;
import com.example.tming.myyueliao.presenter.impl.DynamicPresenterImpl;
import com.example.tming.myyueliao.ui.activity.LoginActivity;
import com.example.tming.myyueliao.view.DynamicView;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2016/12/18.
 */
public class DynamicFragment extends BaseFragment implements DynamicView{
    public static final String TAG = "DynamicFragment";

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.logout)
    Button mLogout;

    private DynamicPresenter mDynamicPresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void init() {
        super.init();
        mDynamicPresenter = new DynamicPresenterImpl(this);
        String logout = String.format(getString(R.string.logout), EMClient.getInstance().getCurrentUser());
        mLogout.setText(logout);
        mTitle.setText(getString(R.string.dynamic));

    }

    @OnClick(R.id.logout)
    public void onClick() {
        mDynamicPresenter.logout();
    }

    @Override
    public void onStartLogout() {
        showProgress(getString(R.string.logouting));
    }

    @Override
    public void onLogoutSuccess() {
        hideProgress();
        toast(getString(R.string.logout_success));
        startActivity(LoginActivity.class, true);
    }

    @Override
    public void onLogoutFailed() {
        hideProgress();
        toast(getString(R.string.logout_failed));
    }
}
