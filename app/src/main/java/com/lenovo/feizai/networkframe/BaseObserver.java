package com.lenovo.feizai.networkframe;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.lenovo.feizai.networkframe.utils.ToastUtil;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author feizai
 * @date 12/31/2020 031 11:45:51 AM
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private Context mContext;
    private ToastUtil toast;
    private final static String TAG = BaseObserver.class.toString();

    public BaseObserver(Context context){
        mContext=context;
        toast = ToastUtil.getInstance(mContext);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.v(TAG,"请求开始");
        showDialog();
    }

    @Override
    public void onNext(T t) {
        hideDialog();
        Log.v(TAG,"请求到数据");
        Integer code = 0;
        if (t instanceof BaseModel) {
            code = ((BaseModel) t).getCode();
        }
        switch (code) {
            case 200:
                successful(t);
                break;
            default:
                defeated(t);
                break;
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.v(TAG,"请求出错Error:"+e.getMessage());
        ExceptionHandle.ResponeThrowable error;
        if (e instanceof ExceptionHandle.ResponeThrowable) {
            error = (ExceptionHandle.ResponeThrowable) e;
        } else {
            error = new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN);
        }
        showErrorMessage(error);
    }

    @Override
    public void onComplete() {
        Log.v(TAG,"请求完成");
        hideDialog();
    }

    protected abstract void showDialog();

    protected abstract void hideDialog();

    protected abstract void successful(T t);

    protected abstract void defeated(T t);

    protected abstract void onError(ExceptionHandle.ResponeThrowable e);

    private void showErrorMessage(ExceptionHandle.ResponeThrowable e) {
        toast.showToast(e.getMessage());
        hideDialog();
        onError(e);
    }
}

