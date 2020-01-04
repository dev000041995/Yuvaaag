package project.com.yuvaaag.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import project.com.yuvaaag.Adapter.LatestFeatureAdapter;
import project.com.yuvaaag.Adapter.LatestNewsAdapter;
import project.com.yuvaaag.Adapter.LatestVideoAdapter;
import project.com.yuvaaag.Adapter.ViewPagerAdapter;
import project.com.yuvaaag.R;


public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(int page, String title) {
        HomeFragment fragmentFirst = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    ViewPager viewpagerStory;
    RecyclerView recylerviewNews,recylerviewVideo,recylerviewFeature,recylerviewCity,recylerviewCountry,recylerviewLifestyle;
    int currentPage = 0;
    final long DELAY_MS = 600;
    final long PERIOD_MS = 10000;
    Timer timer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.home_fragment, container, false);


        viewpagerStory=view.findViewById(R.id.viewpagerStory);

        recylerviewNews=view.findViewById(R.id.recylerviewNews);
        recylerviewVideo=view.findViewById(R.id.recylerviewVideo);
        recylerviewFeature=view.findViewById(R.id.recylerviewFeature);
        recylerviewCity=view.findViewById(R.id.recylerviewCity);
        recylerviewCountry=view.findViewById(R.id.recylerviewCountry);
        recylerviewLifestyle=view.findViewById(R.id.recylerviewLifestyle);

        recylerviewNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerviewCity.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerviewCountry.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerviewVideo.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recylerviewFeature.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recylerviewLifestyle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        final int NUM_PAGES = 4;
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;

                }
                    viewpagerStory.setCurrentItem(currentPage, true);
                    currentPage++; }
        };



        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        viewpagerStory.setAdapter(new ViewPagerAdapter(getActivity()));
        recylerviewNews.setAdapter(new LatestNewsAdapter(getActivity()));
        recylerviewCountry.setAdapter(new LatestNewsAdapter(getActivity()));
        recylerviewCity.setAdapter(new LatestNewsAdapter(getActivity()));
        recylerviewVideo.setAdapter(new LatestVideoAdapter(getActivity()));
        recylerviewFeature.setAdapter(new LatestFeatureAdapter(getActivity()));
        recylerviewLifestyle.setAdapter(new LatestFeatureAdapter(getActivity()));


        return view;


    }
}
