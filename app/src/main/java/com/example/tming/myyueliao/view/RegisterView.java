package com.example.tming.myyueliao.view;

/**
 * Created by lenovo on 2016/12/18.
 */
public interface RegisterView {

    void onStartRegister();

    void onRegisterError();

    void onResisterUserExist();

    void onRegisterSuccess();

    void onUserNameError();

    void onPasswordError();

    void onConfirmPasswordError();
}
