package project.com.yuvaaag.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import project.com.yuvaaag.Adapter.CountryAdapter;
import project.com.yuvaaag.Adapter.LatestNewsAdapter;
import project.com.yuvaaag.Adapter.LatestVideoAdapter;
import project.com.yuvaaag.R;

public class CountryFragment extends Fragment {

    public static CountryFragment newInstance(int page, String title) {
        CountryFragment fragmentFirst = new CountryFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    RecyclerView recylerview;
    RecyclerView recylerviewCountry;
    RecyclerView recylerviewVideo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.country_fragment, container, false);

        recylerview = view.findViewById(R.id.recylerview);
        recylerviewCountry = view.findViewById(R.id.recylerviewCountry);
        recylerviewVideo = view.findViewById(R.id.recylerviewVideo);

        recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerviewCountry.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recylerviewVideo.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        recylerview.setAdapter(new LatestNewsAdapter(getActivity()));
        recylerviewCountry.setAdapter(new CountryAdapter(getActivity()));
        recylerviewVideo.setAdapter(new LatestVideoAdapter(getActivity()));

        return view;

    }

    }
