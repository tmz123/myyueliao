package com.example.tming.myyueliao.view;

/**
 * Created by lenovo on 2016/12/19.
 */
public interface AddFriendView {
    String TAG = "AddFriendView";

    void onStartSearch();

    void onSearchSuccess();

    void onSearchFailed();

    void onAddFriendSuccess();

    void onAddFriendFailed();
}
