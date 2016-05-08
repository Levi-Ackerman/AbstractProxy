package lee.scut.edu.abstractproxy.webview;

import lee.scut.edu.abstractproxy.observe.Subject;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class UCCoreWrapper extends Subject {
    private UCCoreWrapper(){
    }

    private static UCCoreWrapper instance = new UCCoreWrapper();

    public static UCCoreWrapper getInstance(){
       return instance;
    }
    public void notifyListeners(){
        notifyAllListener();
    }
}
