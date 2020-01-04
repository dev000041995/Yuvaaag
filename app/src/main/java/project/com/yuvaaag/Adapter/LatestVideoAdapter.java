package project.com.yuvaaag.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import project.com.yuvaaag.R;
import project.com.yuvaaag.newsinvideo.NewsInVideo;


public class LatestVideoAdapter extends RecyclerView.Adapter<LatestVideoAdapter.MyViewHolder> {

    Context mContext;
    int[] mResources = {
            R.drawable.video1,
            R.drawable.video2,
            R.drawable.video1,
            R.drawable.video2,

    };


    public class MyViewHolder extends RecyclerView.ViewHolder {

       ImageView imageView,ivShare,ivSave;
       TextView tvTitle;

        public MyViewHolder(View view) {
            super(view);

            imageView=view.findViewById(R.id.imageview);
            ivShare=view.findViewById(R.id.ivShare);
            ivSave=view.findViewById(R.id.ivSave);

            tvTitle=view.findViewById(R.id.tvTitle);

        }
    }
    public LatestVideoAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inflate_latest_video, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       holder.imageView.setImageResource(mResources[position]);


       holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(mContext, NewsInVideo.class);
               mContext.startActivity(intent);
           }
       });
    }



    @Override
    public int getItemCount() {
        return mResources.length;
    }





}
