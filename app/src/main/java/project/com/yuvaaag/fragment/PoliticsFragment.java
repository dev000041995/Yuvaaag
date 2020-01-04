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

public class PoliticsFragment extends Fragment {

    public static PoliticsFragment newInstance(int page, String title) {
        PoliticsFragment fragmentFirst = new PoliticsFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    RecyclerView recylerview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.politics_fragment, container, false);

        recylerview = view.findViewById(R.id.recylerview);
        recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerview.setAdapter(new LatestNewsAdapter(getActivity()));

        return view;

    }

    }
