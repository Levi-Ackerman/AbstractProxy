package lee.scut.edu.abstractproxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import lee.scut.edu.abstractproxy.webview.NGWebView;
import lee.scut.edu.abstractproxy.webview.UCCoreWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup root = (ViewGroup) findViewById(R.id.root);
        NGWebView webView = new NGWebView(this);
        root.addView(webView);
        webView.loadUrl("http://www.baidu.com");
        UCCoreWrapper.getInstance().notifyListeners();
    }
}
