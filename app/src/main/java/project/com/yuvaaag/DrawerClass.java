package project.com.yuvaaag;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import project.com.yuvaaag.auth.Forgetpassword;
import project.com.yuvaaag.auth.LoginActivity;
import project.com.yuvaaag.auth.SignUpActivity;
import project.com.yuvaaag.fragment.HomeFragment;
import project.com.yuvaaag.utils.AppSettings;
import project.com.yuvaaag.utils.Preferences;

public class DrawerClass implements View.OnClickListener{
    private DrawerLayout drawer;
    private ImageView menu_;
    private TextView textheader;
    private ImageView logout_img,user_img;
    private Preferences preferences;
    private LinearLayout homeLL,catLL,newsLL,worldLL;
    private ProgressBar progress;

    public void getHeaderFunction(View view, final Context context, String activityName) {
//        sessionManager=new SessionManager(context);
        getviewbyid(view,context,activityName);
        user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, LoginActivity.class));
            }
        });
        menu_.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.START);
                homeLL = (LinearLayout) drawer.findViewById(R.id.homeLL);
                catLL = (LinearLayout) drawer.findViewById(R.id.catLL);
                newsLL = (LinearLayout) drawer.findViewById(R.id.newsLL);
                worldLL = (LinearLayout) drawer.findViewById(R.id.worldLL);





                worldLL.setOnClickListener(this);
            }
        });
    }

    private void getviewbyid(View v, final Context context, String activityName) {
        menu_=(ImageView)v.findViewById(R.id.menu);
        drawer=(DrawerLayout)v.findViewById(R.id.drawer);
        textheader=(TextView)v.findViewById(R.id.textheading);
        logout_img=(ImageView)v.findViewById(R.id.logout);
        user_img=(ImageView)v.findViewById(R.id.user);
        progress=(ProgressBar)v.findViewById(R.id.progress);
        preferences=new Preferences(context);
        if(preferences.get(AppSettings.CustomerID)!=null && !preferences.get(AppSettings.CustomerID).equalsIgnoreCase("")){
            logout_img.setVisibility(View.VISIBLE);
            user_img.setVisibility(View.GONE);
        }
        else {
            logout_img.setVisibility(View.GONE);
            user_img.setVisibility(View.VISIBLE);
        }
        if(context instanceof LoginActivity || context instanceof SignUpActivity ||context instanceof Forgetpassword){
            logout_img.setVisibility(View.GONE);
            user_img.setVisibility(View.GONE);
        }
        textheader.setText(activityName);
        logout_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("Are You sure you want to Log Out ?");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                    }
                                });

                        builder1.setNegativeButton(
                                "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.worldLL:
                HomeFragment.newInstance(0, "Top News");
                break;
        }
    }
}