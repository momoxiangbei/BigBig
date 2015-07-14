package com.momo.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.momo.Fragment.Tab1Fragment;
import com.momo.Fragment.Tab2Fragment;
import com.momo.Fragment.Tab3Fragment;
import com.momo.Fragment.Tab4Fragment;
import com.momo.Fragment.Tab5Fragment;
import com.momo.R;

/**
 * Created by 1 on 2015/7/7.
 */
public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private Tab1Fragment fragment_tab1;
    private Tab2Fragment fragment_tab2;
    private Tab3Fragment fragment_tab3;
    private Tab4Fragment fragment_tab4;
    private Tab5Fragment fragment_tab5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        AVOSCloud.initialize(this, "9s4s3ajec7ul2s4302c1cfe9e739b7v3hww5w2lxmi1ff83p", "jemqsra1vi1gmjey9u1ufb4rd2pkyz5mzhxca1krdanpm6b4");

        AVObject bt = new AVObject("BigBigTest");
        bt.put("momo", "haha");
        bt.saveInBackground();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        setDefaultFragment();

        radioGroup.check(R.id.bottom_tab1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();

                switch (checkedId) {

                    case R.id.bottom_tab1:
                        fragment_tab1 = new Tab1Fragment();
                        transaction.replace(R.id.content, fragment_tab1);
                        break;
                    case R.id.bottom_tab2:
                        fragment_tab2 = new Tab2Fragment();
                        transaction.replace(R.id.content, fragment_tab2);
                        break;
                    case R.id.bottom_tab3:
                        fragment_tab3 = new Tab3Fragment();
                        transaction.replace(R.id.content, fragment_tab3);
                        break;
                    case R.id.bottom_tab4:
                        fragment_tab4 = new Tab4Fragment();
                        transaction.replace(R.id.content, fragment_tab4);
                        break;
                    case R.id.bottom_tab5:
                        fragment_tab5 = new Tab5Fragment();
                        transaction.replace(R.id.content, fragment_tab5);
                        break;
                    default:
                        break;
                }
                transaction.commit();
            }
        });
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment_tab1 = new Tab1Fragment();
        transaction.replace(R.id.content, fragment_tab1);
        transaction.commit();
    }

}
