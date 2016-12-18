package com.example.tming.myyueliao.presenter.impl;

import com.example.tming.myyueliao.presenter.SplashPresenter;
import com.example.tming.myyueliao.view.SplashView;

/**
 * Created by lenovo on 2016/12/18.
 */
public class SplashPresenterImpl implements SplashPresenter{

    public static final String TAG = "SplashPresenterImpl";
    private SplashView splashView;

    public SplashPresenterImpl(SplashView splashView ){
        this.splashView = splashView;
    }

    @Override
    public void checkLoginStatus() {
        splashView.onNotLogin();
//        if (EMClient.getInstance().isLoggedInBefore() && EMClient.getInstance().isConnected()) {
//            splashView.onLoggedIn();
//        } else {
//            splashView.onNotLogin();
//        }
    }
}
