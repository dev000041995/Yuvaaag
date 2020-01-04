package project.com.yuvaaag.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.home_fragment, container, false);


        viewpagerStory=view.findViewById(R.id.viewpagerStory);
        viewpagerStory.setAdapter(new ViewPagerAdapter(getActivity()));

        return view;


    }
}
