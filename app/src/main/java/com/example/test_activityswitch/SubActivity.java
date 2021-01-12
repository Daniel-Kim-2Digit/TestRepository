package com.example.test_activityswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class SubActivity extends AppCompatActivity {

    private TextView mTextView_Counter;
    private int viewCounter=0;

    /**
     *
     * FirebaseAnalytics 관련
     */
    private FirebaseAnalytics mFB_Analytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 구글 애널리틱스 관련 세팅
        mFB_Analytics = FirebaseAnalytics.getInstance(this);

        mTextView_Counter = (TextView) findViewById(R.id.sa_counter);
    }

    public void clickBtn(View view) {

        viewCounter++;
        mTextView_Counter.setText(String.valueOf(viewCounter));

        Bundle bundle = new Bundle();
        bundle.putString("screen_name", "FB_Bom added_Sub");
        bundle.putString("screen_class", "FB_Bom_SubActivity");
        mFB_Analytics.logEvent("Test_Event", bundle);


        Intent intent = new Intent(SubActivity.this, MainActivity.class);
        intent.putExtra("count", 1);

        startActivity(intent);

        //finish();
    }
}