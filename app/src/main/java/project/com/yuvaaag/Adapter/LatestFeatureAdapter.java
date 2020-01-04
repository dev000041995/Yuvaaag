package project.com.yuvaaag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import project.com.yuvaaag.R;


public class LatestFeatureAdapter extends RecyclerView.Adapter<LatestFeatureAdapter.MyViewHolder> {

    Context mContext;
    int[] mResources = {
            R.drawable.econom,
            R.drawable.technology,

    };

    String[] title= new String[] {"Stocks to Watch: Yes Bank, PNB, InterGlobe Aviation, Tata Motors", "Internet Blocked In Many Parts Of UP, Bengal Amid Citizenship Law Protest" };
    String[] category= new String[] {"Economy", "Technology", };


    public class MyViewHolder extends RecyclerView.ViewHolder {

       ImageView imageView;
       TextView tvTitle,tvCategory;

        public MyViewHolder(View view) {
            super(view);

            imageView=view.findViewById(R.id.imageview);
            tvCategory=view.findViewById(R.id.tvCategory);
            tvTitle=view.findViewById(R.id.tvTitle);

        }
    }
    public LatestFeatureAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inflate_latest_feature, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       holder.imageView.setImageResource(mResources[position]);
       holder.tvTitle.setText(title[position]);
       holder.tvCategory.setText(category[position]);


    }



    @Override
    public int getItemCount() {
        return mResources.length;
    }





}
