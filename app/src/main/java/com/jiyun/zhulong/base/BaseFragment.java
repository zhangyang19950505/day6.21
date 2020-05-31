package com.jiyun.zhulong.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jiyun.frame.LoadTypeConfig;
import com.jiyun.zhulong.interfaces.DataListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * 作者：dell  张扬
 * 创建于： 2020/5/31 03:06
 * 作者邮箱：1214476635@qq.com
 */
public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void inStreamListener(SmartRefreshLayout smartRefreshLayout, DataListener dataListener){
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                dataListener.dataType(LoadTypeConfig.LOADMORE);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                dataListener.dataType(LoadTypeConfig.REFRESH);
            }
        });
    }

    public void initRecyclerView(RecyclerView recyclerView){
        if (recyclerView!=null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        }
    }

    public void showLog(String str){
        Log.e("error：", str );
    }

    public void showToast(String str){
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}