package com.fizzer.doraemon.passwordinputdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.fizzer.doraemon.passwordinputdialog.impl.DialogCompleteListener;
import com.fizzer.doraemon.passwordinputdialog.utils.Utils;
import com.fizzer.doraemon.passwordinputdialog.view.PassWordInputView;

/**
 * Created by Fizzer on 2017/4/18.
 * Email: doraemonmqq@sina.com
 */

public class PassWordDialog {

    private Context mContext;
    private Dialog mDialog;
    private PassWordInputView mInputView;

    public PassWordDialog(Context context) {
        mContext = context;
        initDialog();
    }


    /**
     * 初始化对话框样式
     */
    private void initDialog() {
        mDialog = new Dialog(mContext, R.style.FizzerDialogStyle);
        View view = View.inflate(mContext,R.layout.view_password_input_layout,null);
        mDialog.setContentView(view);
        mInputView = new PassWordInputView(mContext,view,this);

        Window dialogwindow = mDialog.getWindow();
        dialogwindow.setGravity(Gravity.BOTTOM);
        dialogwindow.setWindowAnimations(R.style.FizzerDialogAnim);
        WindowManager.LayoutParams lp = dialogwindow.getAttributes();
        lp.width = Utils.getOutMetrics(mContext).widthPixels;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogwindow.setAttributes(lp);
    }

    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public PassWordDialog setTitle(String msg){
        mInputView.setTitle(msg);
        return this;
    }

    public PassWordDialog setSubTitle(String msg){
        mInputView.setSubTitle(msg);
        return this;
    }

    public PassWordDialog setMoney(String msg){
        mInputView.setMoney(msg);
        return this;
    }

    public PassWordDialog setCompleteListener(DialogCompleteListener listener){
        mInputView.setDialogCompleteListener(listener);
        return this;
    }

}
