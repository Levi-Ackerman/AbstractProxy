package lee.scut.edu.abstractproxy.observe;


import java.util.Vector;

/**
 * Created by lizhengxian on 16/5/8.
 */
public abstract class Subject {
    private Vector<Listener> mListeners = new Vector<Listener>();
    public void addListener(Listener listener){
        mListeners.add(listener);
    }
    public void notifyAllListener(){
        for (Listener listener : mListeners) {
            listener.onReady();
        }
    }
}
