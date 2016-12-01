package yutiantian.nomalrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import yutiantian.nomalrecyclerview.R;
import yutiantian.nomalrecyclerview.utils.BaseRecyclerAdapter;
import yutiantian.nomalrecyclerview.utils.ViewHolder;

/**
 * Created by Tina on 2016/12/1.
 * Description:
 */

public class MainAdapter extends BaseRecyclerAdapter<String> {

    public MainAdapter(Context context, RecyclerView recyclerView, int layoutID, List<String> list) {
        super(context, recyclerView, layoutID, list);
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        holder.setText(R.id.tv_right,mLists.get(position));
    }
}
