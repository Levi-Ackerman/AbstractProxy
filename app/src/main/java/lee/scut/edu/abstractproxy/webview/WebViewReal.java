package lee.scut.edu.abstractproxy.webview;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class WebViewReal extends WebView implements IWebView {
    public WebViewReal(Context context) {
        super(context);
    }

    @Override
    public void loadUrl(String url) {
        super.loadUrl(url);
    }
}
