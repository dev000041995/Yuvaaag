package project.com.yuvaaag.newsinvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import project.com.yuvaaag.R;

public class NewsInVideo extends AppCompatActivity {

    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_in_video);
        get_find_view_by_id();
        content.setText(R.string.dummytext);
    }

    private void get_find_view_by_id() {
        content=(TextView)findViewById(R.id.content);
    }
}
