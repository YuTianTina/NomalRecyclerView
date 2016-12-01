package yutiantian.nomalrecyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yutiantian.nomalrecyclerview.R;
import yutiantian.nomalrecyclerview.adapter.MainAdapter;
import yutiantian.nomalrecyclerview.utils.BaseRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv_list)
    RecyclerView rvList;

    protected BaseRecyclerAdapter mAdapter;
    private List<String> mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rvList.setLayoutManager(llm);
        rvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new MainAdapter(this,rvList,R.layout.layout_recycler_item,mList);
        rvList.setAdapter(mAdapter);
        mAdapter.setmOnLoadMoreListener(new BaseRecyclerAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequest() {
                mAdapter.finishLoadMore();
                initData();
            }
        });
        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        initData();
    }

    private void initData() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 20; i++) {
//                DataBean dataBean = new DataBean();
//                dataBean.setHeadMsg(list.size()/20+"");
//                dataBean.setItem("aa" + list.size());
//                list.add(dataBean);
                mAdapter.hasMore=true;
                mList.add(mList.size()+"");
                if(mList.size()>63){
                    mAdapter.hasMore=false;
                    break;
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
