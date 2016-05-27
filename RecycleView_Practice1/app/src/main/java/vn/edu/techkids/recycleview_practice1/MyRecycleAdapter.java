package vn.edu.techkids.recycleview_practice1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 5/27/2016.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.CustomViewHolder> {
    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecycleAdapter( Context mContext, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = mContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        FeedItem feedItem = feedItemList.get(position);

        //Download image using Picasso library
        Picasso.with(mContext).load(feedItem.getImage())
                .into(holder.imageView);
        //setting textview title
        holder.title.setText(Html.fromHtml(feedItem.getTitle()));
        holder.description.setText(Html.fromHtml(feedItem.getDescription()));
        holder.pubDate.setText(Html.fromHtml(feedItem.getPubDate()));

    }

    @Override
    public int getItemCount() {

        return (null != feedItemList?feedItemList.size():0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, description, pubDate;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView)itemView.findViewById(R.id.thumbnail);
            this.title = (TextView)imageView.findViewById(R.id.title);
            this.description = (TextView)imageView.findViewById(R.id.description);
            this.pubDate = (TextView)imageView.findViewById(R.id.pubDate);
        }
    }
}
