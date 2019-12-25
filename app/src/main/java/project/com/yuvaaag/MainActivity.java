package project.com.yuvaaag;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    private String url="http://yuvaaag.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
//        WebView view = (WebView) findViewById(R.id.web);
//        view.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return false;
//            }
//        });
//
//        view.getSettings().setDomStorageEnabled(true);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.getSettings().setAppCacheEnabled(true);
//        view.loadUrl("http://yuvaaag.com/");
//        view.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                return super.onJsAlert(view, url, message, result);
//            }
//            public void onProgressChanged(WebView view, int progress)
//            {
//                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                setTitle("Loading...");
//                setProgress(progress * 100); //Make the bar disappear after URL is loaded
//
//                // Return the app name after finish loading
//                if(progress == 100)
//                    setTitle(R.string.app_name);
//            }
//
//        });
        webView = (WebView) findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl(url);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setMax(100);
        progressBar.setProgress(1);

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                progressBar.setVisibility(View.GONE);
            }
        });
    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//            return false;
//        }
//    }
}
