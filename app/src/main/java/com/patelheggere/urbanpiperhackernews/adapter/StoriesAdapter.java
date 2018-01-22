package com.patelheggere.urbanpiperhackernews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.patelheggere.urbanpiperhackernews.R;
import com.patelheggere.urbanpiperhackernews.model.TopStoriesModel;
import java.util.List;


public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder>
{
    public Context mContext;
    public List<TopStoriesModel> mItems;

    public StoriesAdapter(Context mContext, List<TopStoriesModel> mItems)
    {
        this.mContext = mContext;
        this.mItems = mItems ;

    }

    @Override
    public StoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stories_list, parent, false);
        return new StoriesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoriesAdapter.ViewHolder holder, int position)
    {
        /*ItemsModel item = mItems.get(position);
        if(item!=null)
        {
           if(item.getName()!=null)
               holder.mTvName.setText(item.getName());
           if(item.getFull_name()!=null)
               holder.mTvFullName.setText(item.getFull_name());
           if(item.getWatchers_count()!=0)
               holder.mTvWatcherCount.setText(String.valueOf(item.getWatchers_count()));
           if(item.getOwner().getAvatar_url()!=null) {
               Log.d("Bind", "onBindViewHolder: "+item.getOwner().getAvatar_url());
               Glide.with(mContext)
                       .load(item.getOwner().getAvatar_url())
                       .thumbnail(0.5f)
                       .into(holder.mAvatarImage);
           }
        }*/

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvTile;
        private TextView mTvSubmitter;
        private TextView mTvDateTime;
        private TextView mTvCommentCount;
        private TextView mArticleNumber;

        public ViewHolder(View v) {
            super(v);
            mTvTile = v.findViewById(R.id.tvTitle);
            mTvSubmitter = v.findViewById(R.id.tvSubmitter);
            mTvDateTime = v.findViewById(R.id.tvDateTime);
            mTvCommentCount = v.findViewById(R.id.tvCommentCount);
            mArticleNumber = v.findViewById(R.id.tvCount);
        }
    }
}
