package lee.scut.edu.abstractproxy.proxy;

/**
 * Created by lizhengxian on 16/5/8.
 */
public class Operation {
    private Object mData;
    private int mOperationType;

    public Operation(Object data, int operationType) {
        this.mData = data;
        this.mOperationType = operationType;
    }

    public int getOperationType() {
        return mOperationType;
    }

    public void setOperationType(int operationType) {
        this.mOperationType = operationType;
    }

    public Object getData() {
        return mData;
    }

    public void setData(Object data) {
        this.mData = data;
    }
}
