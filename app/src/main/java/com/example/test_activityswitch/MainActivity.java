package com.example.test_activityswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.test_activityswitch.FuncClass.GA_EventTracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView_Counter;
    private int viewCounter=0;

    private String mStr_ChangedTestForGitHub_VersionControl;

    /**
     *
     * FirebaseAnalytics 관련
     */
    private GA_EventTracker mGA_EventTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 구글 애널리틱스 관련 세팅
        mGA_EventTracker = GA_EventTracker.getInstance(getApplicationContext());

        mTextView_Counter = (TextView) findViewById(R.id.ma_counter);



        int c=1;
        Log.i("Branch_C", String.format("ver1. c=%d", c));

    }

    @Override
    protected void onResume() {
        super.onResume();

        viewCounter++;
        mTextView_Counter.setText(String.valueOf(viewCounter));

        mStr_ChangedTestForGitHub_VersionControl = "A1";
    }

    public void clickBtn(View view) {

        viewCounter++;
        mTextView_Counter.setText(String.valueOf(viewCounter));

        Bundle bundle = new Bundle();
        bundle.putString("screen_name", "FB_Bom_Main_ByTracker");
        bundle.putString("screen_class", "FB_Bom_MainActivity_ByTracker");
        mGA_EventTracker.sendEventLog("Test_Event", bundle);

        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        intent.putExtra("count", 1);

        startActivity(intent);

        //finish();
    }
}