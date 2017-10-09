package com.xzh.zz.fragmentandactivity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by asus on 2017/9/1.
 */
public class ContentFragment1 extends Fragment implements View.OnClickListener {

    private Button mFm1Bt;
    private  F1BtClickListener f1BtClickListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content1, container, false);
        mFm1Bt = (Button) view.findViewById(R.id.fm1_bt);
        mFm1Bt.setOnClickListener(this);
        return view;
    }

    public interface F1BtClickListener{
        void onF1BtClick(String string);
    }

    public void setf1BtClickListener(F1BtClickListener f1BtClickListener){
        this.f1BtClickListener=f1BtClickListener;
    }

    @Override
    public void onClick(View v) {
        if (null != f1BtClickListener){
            f1BtClickListener.onF1BtClick("回调");
        }
    }
}
