package com.example.tming.myyueliao.presenter;

import com.example.tming.myyueliao.model.ContactListItem;

import java.util.List;

/**
 * Created by lenovo on 2016/12/19.
 */
public interface ContactPresenter {

    void getContactsFromServer();

    List<ContactListItem> getContactList();

    void refreshContactList();

    void deleteFriend(String name);
}
