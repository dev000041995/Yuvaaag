package project.com.yuvaaag.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import project.com.yuvaaag.Adapter.ViewPagerAdapter;
import project.com.yuvaaag.R;
import project.com.yuvaaag.newsinvideo.NewsInVideo;


public class HomeFragment extends Fragment {

    private RelativeLayout newsOneRel;

    public static HomeFragment newInstance(int page, String title) {
        HomeFragment fragmentFirst = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    ViewPager viewpagerStory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.home_fragment, container, false);
        newsOneRel=(RelativeLayout)view.findViewById(R.id.newsOneRel);
        newsOneRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), NewsInVideo.class);
                startActivity(intent);
            }
        });
        viewpagerStory=view.findViewById(R.id.viewpagerStory);
        viewpagerStory.setAdapter(new ViewPagerAdapter(getActivity()));

        return view;


    }
}
