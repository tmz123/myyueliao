package com.example.tming.myyueliao.ui.activity;

import android.os.Bundle;

import com.example.tming.myyueliao.R;
import com.example.tming.myyueliao.presenter.SplashPresenter;
import com.example.tming.myyueliao.presenter.impl.SplashPresenterImpl;
import com.example.tming.myyueliao.view.SplashView;


public class SplashActivity extends BaseActivity implements SplashView{

    public static final String TAG = "BaseActivity";
    private static final int DELAY = 2000;

    private SplashPresenter splashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
    }

    @Override
    protected void init() {
        super.init();
        splashPresenter = new SplashPresenterImpl(this);
        splashPresenter.checkLoginStatus();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public void onNotLogin() {
        postDelay(new Runnable() {
            @Override
            public void run() {
               startActivity(LoginActivity.class);
            }
        },DELAY);
    }

    @Override
    public void onLoggedIn() {
        startActivity(MainActivity.class);
    }
}
