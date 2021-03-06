package com.xzh.zz.fragmentandactivity;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by asus on 2017/4/5.
 */

public abstract class MyDialogUtilUtil {

    private Context context;
    private String title,message,negativeStr,neutralStr,positiveStr;
    private boolean cencal;
    public MyDialogUtilUtil(Context context, String title, String message, String negativeStr
            , String neutralStr, String positiveStr, boolean cencal){
        this.context=context;
        this.title=title;
        this.message=message;
        this.negativeStr=negativeStr;
        this.neutralStr=neutralStr;
        this.positiveStr=positiveStr;
        this.cencal=cencal;
    }
    public MyAlertDialogUtil create(){
        final MyAlertDialogUtil alertDialogUtil = new MyAlertDialogUtil(context,cencal);
        if (title != null) {
            alertDialogUtil.setTitle(title);
        }
        if (message != null) {
            alertDialogUtil.setMessage(message);
        }
        if (negativeStr != null) {
            alertDialogUtil.setNegativeOnclickListener(negativeStr, new MyAlertDialogUtil.onNegativeOnclickListener() {
                @Override
                public void onClick() {
                    alertDialogUtil.dismiss();
                    clickNegative();
                }
            });
        }
        if (neutralStr != null) {
            alertDialogUtil.setNeutralOnclickListener(neutralStr, new MyAlertDialogUtil.onNeutralOnclickListener() {
                @Override
                public void onClick() {
                    alertDialogUtil.dismiss();
                    clickNeutral();
                }
            });
        }
        if (positiveStr != null) {
            alertDialogUtil.setPositiveOnclickListener(positiveStr, new MyAlertDialogUtil.onPositiveOnclickListener() {
                @Override
                public void onClick() {
                    alertDialogUtil.dismiss();
                    clickPositive();
                }
            });
        }
        alertDialogUtil.setCancelable(cencal);

        alertDialogUtil.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                clickCancel();
            }
        });
        alertDialogUtil.show();
        return alertDialogUtil;
    }

    /**
     * 点击Negative按钮时
     */
    public abstract void clickNegative();

    /**
     * 点击Neutral按钮时
     */
    public abstract void clickNeutral();

    /**
     * 点击positive按钮时
     */
    public abstract void clickPositive();

    /**
     * dialog取消时
     */
    public abstract void clickCancel();
}
