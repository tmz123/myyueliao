package com.example.tming.myyueliao.presenter;

import com.hyphenate.chat.EMConversation;

import java.util.List;

/**
 * Created by lenovo on 2016/12/19.
 */
public interface ConversationPresenter {

    void loadAllConversations();

    List<EMConversation> getConversations();
}
