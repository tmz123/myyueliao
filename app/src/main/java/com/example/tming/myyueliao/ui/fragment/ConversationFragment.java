package com.example.tming.myyueliao.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.tming.myyueliao.R;
import com.example.tming.myyueliao.adapter.ConversationAdapter;
import com.example.tming.myyueliao.adapter.EMMessageListenerAdapter;
import com.example.tming.myyueliao.presenter.ConversationPresenter;
import com.example.tming.myyueliao.presenter.impl.ConversationPresenterImpl;
import com.example.tming.myyueliao.utils.ThreadUtils;
import com.example.tming.myyueliao.view.ConversationView;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lenovo on 2016/12/18.
 */
public class ConversationFragment extends BaseFragment implements ConversationView{

    public static final String TAG = "ConversationFragment";

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ConversationAdapter mConversationAdapter;

    private ConversationPresenter mConversationPresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_messages;
    }

    @Override
    protected void init() {
        super.init();
        mConversationPresenter = new ConversationPresenterImpl(this);
        mTitle.setText(getString(R.string.messages));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mConversationAdapter =  new ConversationAdapter(getContext(), mConversationPresenter.getConversations());
        mRecyclerView.setAdapter(mConversationAdapter);

        mConversationPresenter.loadAllConversations();
        EMClient.getInstance().chatManager().addMessageListener(mEMMessageListenerAdapter);

    }

    @Override
    public void onAllConversationsLoaded() {
        toast(getString(R.string.load_conversations_success));
        mConversationAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        mConversationAdapter.notifyDataSetChanged();
    }

    private EMMessageListenerAdapter mEMMessageListenerAdapter = new EMMessageListenerAdapter() {

        // 该方法在子线程中回调
        @Override
        public void onMessageReceived(List<EMMessage> list) {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mConversationPresenter.loadAllConversations();
                }
            });
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(mEMMessageListenerAdapter);
    }
}
