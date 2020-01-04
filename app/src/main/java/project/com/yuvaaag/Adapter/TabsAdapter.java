package project.com.yuvaaag.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import project.com.yuvaaag.fragment.CountryFragment;
import project.com.yuvaaag.fragment.HomeFragment;
import project.com.yuvaaag.fragment.PoliticsFragment;
import project.com.yuvaaag.fragment.WorldFragment;

public class TabsAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 10;
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public TabsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return  HomeFragment.newInstance(0, "Top News");
            case 1:
                return WorldFragment.newInstance(1, "World");
            case 2:
                return CountryFragment.newInstance(2, "India");
            case 3:
                return PoliticsFragment.newInstance(3, "Politics");
            case 4:
                return PoliticsFragment.newInstance(4, "Business");
            case 5:
                return PoliticsFragment.newInstance(5, "Economy");
            case 6:
                return PoliticsFragment.newInstance(6, "Travel");
            case 7:
                return PoliticsFragment.newInstance(7, "Technology");
            case 8:
                return PoliticsFragment.newInstance(8, "LifeStyle");
            case 9:
                return PoliticsFragment.newInstance(9, "Sport");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
        {
            mFragmentTitleList.add("Top News");
        }
      else  if (position==1)
        {
            mFragmentTitleList.add("World");
        }
        else  if (position==2)
        {
            mFragmentTitleList.add("India");
        }
        else  if (position==3)
        {
            mFragmentTitleList.add("Politics");
        }
        else  if (position==4)
        {
            mFragmentTitleList.add("Business");
        }
        else  if (position==5)
        {
            mFragmentTitleList.add("Economy");
        }

        else  if (position==6)
        {
            mFragmentTitleList.add("Travel");
        }

        else  if (position==7)
        {
            mFragmentTitleList.add("Technology");
        }

        else  if (position==8)
        {
            mFragmentTitleList.add("LifeStyle");
        }

        else  if (position==9)
        {
            mFragmentTitleList.add("Sport");
        }

        return mFragmentTitleList.get(position);
    }

}
