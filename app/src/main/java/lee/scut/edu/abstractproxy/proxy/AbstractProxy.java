package lee.scut.edu.abstractproxy.proxy;

import java.util.Vector;

import lee.scut.edu.abstractproxy.observe.Listener;

/**
 * Created by lizhengxian on 16/5/8.
 */
public abstract class AbstractProxy<AI> implements Listener{
    /**
     * Action Interface
     * 需要代理类接管的操作接口，代理类除了实现AI接口，还持有一个真正的该接口实体
     */
    protected AI mObjEx;

    /**
     * 用来在未Ready情况下缓存操作
     */
    private Vector<Operation> mOperations =new Vector<Operation>();
    /**
     * 是否可以直接对实体mObjEx操作
     * @return
     */
    protected boolean isReady(){
        return mObjEx != null;
    }

    protected void executeCachedOperations(){
        for (Operation operation : mOperations) {
            this.executeOperation(operation.getOperationType(),operation.getData());
        }
    }

    protected abstract void executeOperation(int type, Object data);

    protected void handleMessage(Operation operation){
        mOperations.add(operation);
        if (isReady()){
            executeCachedOperations();
        }
    }
}
