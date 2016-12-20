package com.example.tming.myyueliao.ui.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tming.myyueliao.R;
import com.example.tming.myyueliao.presenter.LoginPresenter;
import com.example.tming.myyueliao.presenter.impl.LoginPresenterImpl;
import com.example.tming.myyueliao.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tming on 2016/12/18.
 */
public class LoginActivity extends BaseActivity implements LoginView{

    public static final String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;

    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.password)
    EditText mPassword;

    @OnClick({R.id.login, R.id.new_user})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startLogin();
                break;
            case R.id.new_user:
                startActivity(RegisterActivity.class);
                break;
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        super.init();
        loginPresenter = new LoginPresenterImpl(this);
        mPassword.setOnEditorActionListener(mOnEditorActionListener);

    }

    private void startLogin() {
        hideKeyBoard();
        String userName = mUserName.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        loginPresenter.login(userName, password);
    }

    @Override
    public void onUserNameError() {
        mUserName.setError(getString(R.string.user_name_error));
    }

    @Override
    public void onPasswordError() {
        mPassword.setError(getString(R.string.user_password_error));
    }

    @Override
    public void onStartLogin() {
        showProgress(getString(R.string.logining));
    }

    @Override
    public void onLoginSuccess() {
        hideProgress();
        toast(getString(R.string.login_success));
        startActivity(MainActivity.class);
    }

    @Override
    public void onLoginFailed() {
        hideProgress();
        toast(getString(R.string.login_failed));
    }

    private TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_GO) {
                startLogin();
                return true;
            }
            return false;
        }
    };
}
