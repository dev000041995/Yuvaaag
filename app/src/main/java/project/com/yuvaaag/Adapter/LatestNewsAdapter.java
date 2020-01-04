package project.com.yuvaaag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import project.com.yuvaaag.R;


public class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.MyViewHolder> {

    Context mContext;
    int[] mResources = {
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news4,

    };

    String[] title= new String[] {"Can't escape responsibility, no point blaming past govt: Sachin Pilot on Kota infants deaths", "Nankana Sahib attack proof of persecution in Pakistan: BJP makes case for CAA over attack on Sikhs","Guwahati absolutely safe, would be irresponsible of me to comment on CAA: Virat Kohli","Slain Iran Gen Qassem Soleimani behind terror plots even in Delhi, claims Donald Trump" };


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
    public LatestNewsAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inflate_latest_news, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       holder.imageView.setImageResource(mResources[position]);
       holder.tvTitle.setText(title[position]);


    }



    @Override
    public int getItemCount() {
        return mResources.length;
    }





}
