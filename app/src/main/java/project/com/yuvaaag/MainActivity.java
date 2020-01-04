package project.com.yuvaaag;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView menu_drawer;
    private Spinner category_spin;
    private ArrayList<String> dataArray_city;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_findViewById();
        dataArray_city=new ArrayList<>();
        dataArray_city.add("Select Category");
//            A_Service_URL.getToast(getApplicationContext(),"No Internet Connection");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, dataArray_city);//setting the country_array to spinner
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spin.setAdapter(adapter1);
    }

    private void get_findViewById() {
        menu_drawer=(ImageView)findViewById(R.id.menu);
        category_spin=(Spinner)findViewById(R.id.category_spin);
        progress=(ProgressBar)findViewById(R.id.progress);
        dataArray_city=new ArrayList<>();
        DrawerClass drawerClass = new DrawerClass();
        drawerClass.getHeaderFunction(this.findViewById(android.R.id.content), MainActivity.this, "Dashboard");
    }
}
