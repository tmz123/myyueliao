package com.example.tming.myyueliao.presenter.impl;

import com.example.tming.myyueliao.adapter.EMCallBackAdapter;
import com.example.tming.myyueliao.presenter.DynamicPresenter;
import com.example.tming.myyueliao.utils.ThreadUtils;
import com.example.tming.myyueliao.view.DynamicView;
import com.hyphenate.chat.EMClient;

/**
 * Created by lenovo on 2016/12/19.
 */
public class DynamicPresenterImpl implements DynamicPresenter {
        private DynamicView mDynamicView;

        public DynamicPresenterImpl(DynamicView dynamicView) {
            mDynamicView = dynamicView;
        }

        @Override
        public void logout() {
            mDynamicView.onStartLogout();
            EMClient.getInstance().logout(true, mEMCallBackAdapter);
        }

        private EMCallBackAdapter mEMCallBackAdapter = new EMCallBackAdapter() {

            @Override
            public void onSuccess() {
                ThreadUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDynamicView.onLogoutSuccess();
                    }
                });
            }

            @Override
            public void onError(int i, String s) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDynamicView.onLogoutFailed();
                    }
                });
            }
        };
    }

