package com.example.tming.myyueliao.presenter.impl;

import com.example.tming.myyueliao.adapter.EMCallBackAdapter;
import com.example.tming.myyueliao.presenter.LoginPresenter;
import com.example.tming.myyueliao.utils.StringUtils;
import com.example.tming.myyueliao.utils.ThreadUtils;
import com.example.tming.myyueliao.view.LoginView;
import com.hyphenate.chat.EMClient;

/**
 * Created by lenovo on 2016/12/18.
 */
public class LoginPresenterImpl implements LoginPresenter{

    public static final String TAG = "LoginPresenterImpl";


    public LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
    }

    @Override
    public void login(String userName, String pwd) {
        if (StringUtils.checkUserName(userName)) {
            if (StringUtils.checkPassword(pwd)) {
                mLoginView.onStartLogin();
                startLogin(userName, pwd);
            } else {
                mLoginView.onPasswordError();
            }
        } else {
            mLoginView.onUserNameError();
        }
    }

    private void startLogin(String userName, String pwd) {
        EMClient.getInstance().login(userName, pwd, mEMCallBack);
    }

    /**
     * 登录是同步的，所以是需要在工作线程中工作的
     */
    private EMCallBackAdapter mEMCallBack = new EMCallBackAdapter() {

        @Override
        public void onSuccess() {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoginView.onLoginSuccess();
                }
            });
        }

        @Override
        public void onError(int i, String s) {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoginView.onLoginFailed();
                }
            });
        }
    };
}