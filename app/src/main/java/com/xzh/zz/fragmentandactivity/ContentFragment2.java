package com.xzh.zz.fragmentandactivity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by asus on 2017/9/1.
 */
public class ContentFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_ll_root);
        TextView textView = new TextView(getActivity());
        textView.setText("contentFragment22222");
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(20);
        textView.setX(getActivity().getWindowManager().getDefaultDisplay().getWidth()/3);
        textView.setY(getActivity().getWindowManager().getDefaultDisplay().getHeight()/3);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.addView(textView,params);
        return view;
    }
}
