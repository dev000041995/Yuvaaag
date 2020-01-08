package project.com.yuvaaag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import project.com.yuvaaag.Adapter.TabsAdapter;
import project.com.yuvaaag.auth.LoginActivity;
import project.com.yuvaaag.utils.AppSettings;
import project.com.yuvaaag.utils.Preferences;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{

    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawer;
    NavigationView navigationView;
    LinearLayout homeLL,catLL,newsLL,worldLL;
    LinearLayout countryLL,stateLL,politicLL,dealsLL;
    LinearLayout businessLL,economyLL,travelLL,techLL;
    LinearLayout lifestyleLL,sportLL;
    ImageView ivMenu;
    TextView tvHeader;
    ImageView logout_img,user_img;
    Preferences preferences;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        findViewById();

        //NavigationView
        navigationView =findViewById(R.id.navigation_view);
        View headerview= navigationView.getHeaderView(0);

         //findViewId In NavigationView
        findIdNavigationView(headerview);


        if(preferences.get(AppSettings.CustomerID)!=null && !preferences.get(AppSettings.CustomerID).equalsIgnoreCase("")){
            logout_img.setVisibility(View.VISIBLE);
            user_img.setVisibility(View.GONE);
        }
        else {
            logout_img.setVisibility(View.GONE);
            user_img.setVisibility(View.VISIBLE);
        }



        //setOnCLickListener
       setOnClickListener();


    }

    private void setupViewPager(final ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

    }


    public void findViewById()
    {
        //DrawerLayout
        drawer       =findViewById(R.id.drawer);

        //Tablayout
        tabLayout    = findViewById(R.id.tabs);

        //ImageView
        ivMenu       =findViewById(R.id.menu);
        logout_img   =findViewById(R.id.logout);
        user_img     =findViewById(R.id.user);

        //Pref
        preferences=new Preferences(this);


        //textview
        tvHeader   =findViewById(R.id.textheading);


        //Progress
        progress     =findViewById(R.id.progress);


        //ViewPager
        viewPager    = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


        tvHeader.setText("Yuvaaag");

    }

    private void findIdNavigationView(View view)
    {
        homeLL      = view.findViewById(R.id.homeLL);
        catLL       = view.findViewById(R.id.catLL);
        newsLL      = view.findViewById(R.id.newsLL);
        worldLL     = view.findViewById(R.id.worldLL);
        countryLL   = view.findViewById(R.id.countryLL);
        stateLL     = view.findViewById(R.id.stateLL);
        dealsLL     = view.findViewById(R.id.dealsLL);
        businessLL  = view.findViewById(R.id.businessLL);
        economyLL   = view.findViewById(R.id.economyLL);
        travelLL    = view.findViewById(R.id.travelLL);
        techLL      = view.findViewById(R.id.techLL);
        politicLL   = view.findViewById(R.id.politicLL);
        lifestyleLL = view.findViewById(R.id.lifestyleLL);
        sportLL     = view.findViewById(R.id.sportLL);

    }

    public void setOnClickListener()
    {
        ivMenu.setOnClickListener(this);
        user_img.setOnClickListener(this);
        homeLL.setOnClickListener(this);
        catLL.setOnClickListener(this);
        newsLL.setOnClickListener(this);
        worldLL.setOnClickListener(this);
        countryLL.setOnClickListener(this);
        stateLL.setOnClickListener(this);
        dealsLL.setOnClickListener(this);
        businessLL.setOnClickListener(this);
        economyLL.setOnClickListener(this);
        travelLL.setOnClickListener(this);
        techLL.setOnClickListener(this);
        politicLL.setOnClickListener(this);
        lifestyleLL.setOnClickListener(this);
        sportLL.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onClick(View view) {
       switch (view.getId())
       {
           case R.id.menu:
               drawer.openDrawer(Gravity.START);
               break;
           case R.id.user:
               startActivity(new Intent(this, LoginActivity.class));
               break;
           case R.id.homeLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(0);
               break;

           case R.id.worldLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(1);
               break;

           case R.id.countryLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(2);
               break;

//           case R.id.stateLL:
//               drawer.closeDrawers();
//               viewPager.setCurrentItem(2);
//               break;
           case R.id.politicLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(3);
               break;
           case R.id.businessLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(4);
               break;
           case R.id.economyLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(5);
               break;
           case R.id.travelLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(6);
               break;
           case R.id.techLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(7);
               break;
           case R.id.lifestyleLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(8);
               break;
           case R.id.sportLL:
               drawer.closeDrawers();
               viewPager.setCurrentItem(9);
               break;


       }
    }



}
