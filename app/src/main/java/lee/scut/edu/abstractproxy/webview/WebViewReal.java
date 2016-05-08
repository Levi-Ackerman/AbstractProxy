package lee.scut.edu.abstractproxy.webview;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class WebViewReal extends WebView implements IWebView {
    public WebViewReal(Context context) {
        super(context);
        WebViewClient client = new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        setWebViewClient(client);
    }

    @Override
    public void loadUrl(String url) {
        super.loadUrl(url);
    }
}
