package com.example.tming.myyueliao.view;

/**
 * Created by lenovo on 2016/12/18.
 */
public interface LoginView {

    String TAG = "LoginView";

    void onUserNameError();

    void onPasswordError();

    void onStartLogin();

    void onLoginSuccess();

    void onLoginFailed();
}
