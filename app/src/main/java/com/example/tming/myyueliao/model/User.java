package com.example.tming.myyueliao.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by lenovo on 2016/12/18.
 */
public class User extends BmobUser {
        public User(String userName, String password) {
            setUsername(userName);
            setPassword(password);
        }
}
