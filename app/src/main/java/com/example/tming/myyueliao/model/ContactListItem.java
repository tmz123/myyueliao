package com.example.tming.myyueliao.model;

import com.example.tming.myyueliao.R;

/**
 * Created by lenovo on 2016/12/19.
 */
public class ContactListItem {
    public static final String TAG = "ContactListItem";

    public int avatar = R.mipmap.avatar6;

    public String userName;

    public boolean showFirstLetter = true;

    public char getFirstLetter() {
        return userName.charAt(0);
    }

    public String getFirstLetterString() {
        return String.valueOf(getFirstLetter()).toUpperCase();
    }
}
