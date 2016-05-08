package lee.scut.edu.abstractproxy.webview;

import android.content.Context;
import android.widget.FrameLayout;

import lee.scut.edu.abstractproxy.proxy.Operation;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class NGWebView extends FrameLayout implements IWebView
{
    private WebViewProxy proxy;
    public NGWebView(Context context) {
        super(context);
        proxy = new WebViewProxy(context);
        proxy.handleMessage(new Operation(this,WebViewProxy.ADD_IN_PARENT_VIEW));
    }

    @Override
    public void loadUrl(String url) {
        proxy.handleMessage(new Operation(url,WebViewProxy.LOAD_URL));
    }
}
