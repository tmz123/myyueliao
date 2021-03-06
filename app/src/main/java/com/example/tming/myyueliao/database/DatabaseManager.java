package com.example.tming.myyueliao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.tming.myyueliao.app.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/12/19.
 */
public class DatabaseManager {
    public static final String TAG = "DatabaseManager";

    private static DatabaseManager sInstance;
    private DaoSession mDaoSession;


    public static DatabaseManager getInstance() {
        if (sInstance == null) {
            synchronized (DatabaseManager.class) {
                if (sInstance == null) {
                    sInstance = new DatabaseManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, Constant.Database.DATABASE_NAME, null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        mDaoSession = daoMaster.newSession();
    }

    public void saveContact(String userName) {
        Contact contact = new Contact();
        contact.setUsername(userName);
        mDaoSession.getContactDao().save(contact);
    }

    public List<String> queryAllContacts() {
        List<Contact> list = mDaoSession.getContactDao().queryBuilder().list();
        ArrayList<String> contacts = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String contact = list.get(i).getUsername();
            contacts.add(contact);
        }
        return contacts;
    }

    public void deleteAllContacts() {
        ContactDao contactDao = mDaoSession.getContactDao();
        contactDao.deleteAll();
    }
}
