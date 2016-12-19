package com.example.tming.myyueliao.event;

/**
 * Created by lenovo on 2016/12/19.
 */
public class AddFriendEvent {

    public static final String TAG = "AddFriendEvent";

    private String mFriendName;

    private String mReason;

    public AddFriendEvent(String friendName, String reason) {
        this.mFriendName = friendName;
        this.mReason = reason;
    }


    public String getFriendName() {
        return mFriendName;
    }

    public void setFriendName(String friendName) {
        this.mFriendName = friendName;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String reason) {
        this.mReason = reason;
    }
}
