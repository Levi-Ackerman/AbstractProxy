package lee.scut.edu.abstractproxy.webview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.lang.reflect.Constructor;

import lee.scut.edu.abstractproxy.proxy.AbstractProxy;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class WebViewProxy extends AbstractProxy<IWebView> {

    public static final int LOAD_URL = 1;
    public static final int ADD_IN_PARENT_VIEW = 2;

    private Context mContext;

    public WebViewProxy(Context context){
        this.mContext = context;
    }

    @Override
    protected void executeOperation(int type, Object data) {
        switch (type){
            case LOAD_URL:
                mObjEx.loadUrl(data.toString());
                Log.i("lee.","load url "+data.toString());
                break;
            case ADD_IN_PARENT_VIEW:
                FrameLayout viewGroup = (FrameLayout)data;
                viewGroup.addView((View) mObjEx,new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
                Log.i("lee.","add view");
                break;
        }
    }

    @Override
    public void doReady() {
        try {

            Class webViewClass = Class.forName("lee.scut.edu.abstractproxy.webview.WebViewReal");
            Constructor constructor = webViewClass.getConstructor(Context.class);
            mObjEx = (IWebView) constructor.newInstance(mContext);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
