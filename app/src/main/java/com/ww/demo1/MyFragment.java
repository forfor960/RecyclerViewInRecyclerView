package com.ww.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingzi on 2017/6/26.
 */

public class MyFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String FRAGMENT_PAGE = "FRAGMENT_PAGE";
    private CustomVRecyclerView mCustomVRecyclerView;
    private CustomHRecyclerView mCustomHRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BaseQuickAdapter mCustomVRecyclerView_Adapter;
    private BaseQuickAdapter mCustomHRecyclerView_Adapter;
    private View headView;
    List<String> testLists = new ArrayList<String>();

    public static MyFragment newInstance(String page) {
        Bundle args = new Bundle();
        args.putString(FRAGMENT_PAGE, page);
        MyFragment pageFragment = new MyFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        testLists.add("test1");
        testLists.add("test2");
        testLists.add("test3");
        testLists.add("test4");
        testLists.add("test5");
        testLists.add("test6");
        testLists.add("test7");
        testLists.add("test8");
        mCustomVRecyclerView = (CustomVRecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mCustomVRecyclerView.setLayoutManager(layoutManager);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        headView = LayoutInflater.from(getActivity()).inflate(R.layout.horizontal_recyclerview, null);
        mCustomHRecyclerView = (CustomHRecyclerView) headView.findViewById(R.id.horizontal_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCustomHRecyclerView.setLayoutManager(linearLayoutManager);
        mCustomHRecyclerView.setNestParent(mSwipeRefreshLayout);

        mCustomVRecyclerView_Adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.recyclerview_item, testLists) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.text, item);
            }
        };
        mCustomVRecyclerView.setAdapter(mCustomVRecyclerView_Adapter);

        mCustomHRecyclerView_Adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.horizontal_recyclerview_item, testLists) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setImageResource(R.id.image, R.mipmap.ic_launcher);
            }
        };
        mCustomHRecyclerView.setAdapter(mCustomHRecyclerView_Adapter);
        mCustomHRecyclerView_Adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
        mCustomVRecyclerView_Adapter.addHeaderView(headView);

    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
