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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progress;
    private TextView tv_signup,tv_forget_pass;
    private Button login_btn;
    private EditText et_email,etPass;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        get_viewById();

    }

    private void get_viewById() {
        progress=(ProgressBar)findViewById(R.id.progress);
        tv_signup=(TextView)findViewById(R.id.tvSignupbtn);
        login_btn=(Button)findViewById(R.id.tvLoginButton);
        et_email=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPassword);
        tv_forget_pass=(TextView)findViewById(R.id.tvForgotPassword);

        ivBack=findViewById(R.id.ivBack);
        progress.setVisibility(View.GONE);

        //SetOnClickListener
        ivBack.setOnClickListener(this);
        tv_signup.setOnClickListener(this);

    }
    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tvSignupbtn:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
