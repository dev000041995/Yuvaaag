package project.com.yuvaaag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

import project.com.yuvaaag.R;


public class ViewPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    int[] mResources = {
            R.drawable.pager1,
            R.drawable.pager2,
            R.drawable.pager3

    };

    String[] title= new String[] {"PM MODI URGES PEOPLE TO VOTE IN 4TH PHASE OF JHARKHAND ASSEMBLY ELECTION", "WATCH: HOW INDIAN ARMY GUARDS LOC IN MINUS 20 DEGREES CELSIUS","7 YEARS ON, DESPAIR SHROUDS NIRBHAYA’S CONVICT’S HOME, AND COLONY" };


    public ViewPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.viewpager, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageview);
        TextView tv1=itemView.findViewById(R.id.tv1);

        imageView.setImageResource(mResources[position]);
        tv1.setText(title[position]);


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
