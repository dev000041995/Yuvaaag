package project.com.yuvaaag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import project.com.yuvaaag.R;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    Context mContext;
    String[] title= new String[] {"Uttar Pradesh","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar" };




    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountry;

        public MyViewHolder(View view) {
            super(view);

            tvCountry=view.findViewById(R.id.tvCountry);

        }
    }
    public CountryAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inflate_country_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       holder.tvCountry.setText(title[position]);
    }



    @Override
    public int getItemCount() {
        return title.length;
    }





}
