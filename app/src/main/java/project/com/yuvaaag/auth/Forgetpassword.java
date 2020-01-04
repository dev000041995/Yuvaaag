package project.com.yuvaaag.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import project.com.yuvaaag.DrawerClass;
import project.com.yuvaaag.MainActivity;
import project.com.yuvaaag.R;

public class Forgetpassword extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar progress;
    private TextView tvSignUp,tvLogin;
    private EditText et_email;
    ImageView ivBack;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        get_viewById();

    }
    private void get_viewById() {
        progress=(ProgressBar)findViewById(R.id.progress);
        tvSignUp=(TextView)findViewById(R.id.tvSignUp);
        tvLogin=(TextView)findViewById(R.id.tvLogin);
        et_email=(EditText)findViewById(R.id.etEmail);

        btnSend=findViewById(R.id.btnSend);
        ivBack  =findViewById(R.id.ivBack);

        progress.setVisibility(View.GONE);

        //SetOnClickListener
        ivBack.setOnClickListener(this);
        btnSend.setOnClickListener(this);

    }
    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ivBack:
                finish();
                break;
            case R.id.btnSend:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
    }
}
