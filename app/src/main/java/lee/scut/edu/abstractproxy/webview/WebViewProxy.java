package lee.scut.edu.abstractproxy.webview;

import android.content.Context;
import android.webkit.WebView;

import java.lang.reflect.Constructor;
import java.net.URL;

import lee.scut.edu.abstractproxy.proxy.AbstractProxy;
import lee.scut.edu.abstractproxy.proxy.Operation;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class WebViewProxy extends AbstractProxy<IWebView> implements IWebView{

    private Context mContext;

    public WebViewProxy(Context context){
        this.mContext = context;
    }

    @Override
    public void loadUrl(String url) {
        handleMessage(new Operation(url,LOAD_URL));
    }

    @Override
    protected void executeOperation(int type, Object data) {
        switch (type){
            case LOAD_URL:
                mObjEx.loadUrl(data.toString());
                break;
        }
    }

    @Override
    public void onReady() {
        try {

            Class webViewClass = Class.forName("lee.scut.edu.abstractproxy.webview.WebViewReal");
            Constructor constructor = webViewClass.getConstructor(Context.class);
            mObjEx = (IWebView) constructor.newInstance(mContext);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static final int LOAD_URL=1;
}
