package com.xzh.zz.fragmentandactivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContentFragment.F0BtClickListener, ContentFragment1.F1BtClickListener {

    private ImageButton mId0;
    private ImageButton mId1;
    private ImageButton mId2;
    private ImageButton mId3;
    private ContentFragment contentFragment=null;
    private ContentFragment1 contentFragment1=null;
    private ContentFragment2 contentFragment2=null;
    private ContentFragment3 contentFragment3=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        mId0 = (ImageButton) findViewById(R.id.main_ib_0);
        mId1 = (ImageButton) findViewById(R.id.main_ib_1);
        mId2 = (ImageButton) findViewById(R.id.main_ib_2);
        mId3 = (ImageButton) findViewById(R.id.main_ib_3);

        /*MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getFragmentManager(),"myDialogFragment");*/
        mId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog(false);
            }
        });
        mId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog(true);
            }
        });


        //默认的fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        contentFragment = new ContentFragment();
        transaction.replace(R.id.main_fl_content, contentFragment,"contentFragment");
        transaction.commit();
    }

    private void showMyDialog(boolean cancel){
        new MyDialogUtilUtil(this, "dialogFragment", "舍弃alertDialog,使用dialogFragment", "取消"
                , "不知道", "确定", cancel) {
            @Override
            public void clickNegative() {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickNeutral() {
                Toast.makeText(MainActivity.this, "不知道", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickPositive() {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickCancel() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        }.create();
    }




    private void showDialog(boolean cancel) {
        DialogFragmentUtil dialogFragmentUtil = new DialogFragmentUtil(this, "dialogFragment", "舍弃alertDialog,使用dialogFragment", "取消"
                , "不知道", "确定", cancel) {
            @Override
            public void clickNegative() {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickNeutral() {
                Toast.makeText(MainActivity.this, "不知道", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickPositive() {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

            /*@Override
            public void clickCancel() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }*/
        };
        dialogFragmentUtil.show(getFragmentManager(),"dialogFragmentUtil");
    }


    @Override
    public void onF0BtClick(String string) {
        if (null ==contentFragment1){
            contentFragment1=new ContentFragment1();
            contentFragment1.setf1BtClickListener(this);
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fl_content,contentFragment1,"contentFragment1");
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onF1BtClick(String string) {
        if (null ==contentFragment2){
            contentFragment2=new ContentFragment2();
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fl_content,contentFragment2,"contentFragment2");
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
