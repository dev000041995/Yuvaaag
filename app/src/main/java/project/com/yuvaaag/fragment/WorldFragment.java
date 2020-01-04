package project.com.yuvaaag.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import project.com.yuvaaag.Adapter.LatestNewsAdapter;
import project.com.yuvaaag.Adapter.LatestVideoAdapter;
import project.com.yuvaaag.R;

public class WorldFragment extends Fragment {

    public static WorldFragment newInstance(int page, String title) {
        WorldFragment fragmentFirst = new WorldFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    RecyclerView recylerview;
    RecyclerView recylerviewVideo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.world_fragment, container, false);

        recylerview = view.findViewById(R.id.recylerview);
        recylerviewVideo = view.findViewById(R.id.recylerviewVideo);
        recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerviewVideo.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        recylerview.setAdapter(new LatestNewsAdapter(getActivity()));
        recylerviewVideo.setAdapter(new LatestVideoAdapter(getActivity()));


        return view;

    }

    }
