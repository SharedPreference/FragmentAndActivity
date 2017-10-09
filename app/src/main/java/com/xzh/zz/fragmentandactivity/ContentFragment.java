package com.xzh.zz.fragmentandactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by asus on 2017/9/1.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {

    private Button mFm0Bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mFm0Bt = (Button) view.findViewById(R.id.fm0_bt);
        mFm0Bt.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_menu_fra_test:
                Toast.makeText(getActivity(), "contentFragment", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    /**
     * 按钮回调
     */
    public interface F0BtClickListener{
        void onF0BtClick(String string);
    }

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof F0BtClickListener){
            ((F0BtClickListener) getActivity()).onF0BtClick("钩子");
        }
    }
}
