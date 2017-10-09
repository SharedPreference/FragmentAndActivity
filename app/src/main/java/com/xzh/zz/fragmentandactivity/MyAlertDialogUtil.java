package com.xzh.zz.fragmentandactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyAlertDialogUtil extends AlertDialog {

    private Button positive;//确定按钮
    private Button negative;//取消按钮
    private Button neutral;
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示内容
    private String positiveStr, negativeStr, neutralStr;

    private onNegativeOnclickListener negativeOnclickListener;//取消按钮被点击了的监听器
    private onPositiveOnclickListener positiveOnclickListener;//确定按钮被点击了的监听器
    private onNeutralOnclickListener neutralOnclickListener;//确定按钮被点击了的监听器
    private View mLine1;
    private View mLine2;
    private boolean cancelAble;

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNegativeOnclickListener(String str, onNegativeOnclickListener onNoOnclickListener) {
        if (str != null) {
            negativeStr = str;
        }
        this.negativeOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setPositiveOnclickListener(String str, onPositiveOnclickListener onYesOnclickListener) {
        if (str != null) {
            positiveStr = str;
        }
        this.positiveOnclickListener = onYesOnclickListener;
    }

    public void setNeutralOnclickListener(String str, onNeutralOnclickListener onNuteOnclickListener){
        if (str!=null){
            neutralStr=str;
        }
        this.neutralOnclickListener=onNuteOnclickListener;
    }

    public MyAlertDialogUtil(Context context,boolean cancel) {
        super(context, R.style.Translucent_NoTitle);
        this.cancelAble=cancel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(cancelAble);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positiveOnclickListener != null) {
                    positiveOnclickListener.onClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (negativeOnclickListener != null) {
                    negativeOnclickListener.onClick();
                }
            }
        });
        //设置中间按钮被点击后，向外界提供监听
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (neutralOnclickListener != null) {
                    neutralOnclickListener.onClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setVisibility(View.VISIBLE);
            messageTv.setText(messageStr);
        }
        //如果设置按钮的文字
        if (positiveStr != null) {
            positive.setText(positiveStr);
        }
        if (negativeStr != null) {
            negative.setText(negativeStr);
            negative.setVisibility(View.VISIBLE);
        }else {
            mLine1.setVisibility(View.GONE);
            mLine2.setVisibility(View.GONE);
        }

        if (neutralStr != null) {
            neutral.setVisibility(View.VISIBLE);
            neutral.setText(neutralStr);
        }else {
            mLine2.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        positive = (Button) findViewById(R.id.positive);
        negative = (Button) findViewById(R.id.negative);
        neutral = (Button) findViewById(R.id.neutral);

        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);

        mLine1 = (View)findViewById(R.id.line_mydialog1);
        mLine2 = (View)findViewById(R.id.line_mydialog2);
    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onPositiveOnclickListener {
        void onClick();
    }

    public interface onNegativeOnclickListener {
        void onClick();
    }

    public interface onNeutralOnclickListener{
        void onClick();
    }
}