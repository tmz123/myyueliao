package com.example.tming.myyueliao.presenter;

import com.example.tming.myyueliao.model.AddFriendItem;

import java.util.List;

/**
 * Created by lenovo on 2016/12/19.
 */
public interface AddFriendPresenter {
    String TAG = "AddFriendPresenter";

    void searchFriend(String keyword);

    void onDestroy();

    List<AddFriendItem> getAddFriendList();
}
