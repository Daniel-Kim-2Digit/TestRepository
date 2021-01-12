package com.example.test_activityswitch.FuncClass;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/*
 * 해당 클래스는 Google Analitics(GA)에 앱에서 발생하는 이벤트를 추적할 수 있도록 데이터 처리를 하는 클래스입니다.
 * 이 클래스를 사용하기 위해서는 GA에 계정과 속성을 세팅하고 데이터스트림 연동하여 통신 연결을 확인하고 사용하기 바랍니다.
 */
public class GA_EventTracker {

    static private GA_EventTracker mSingletonInstance = null;    // singleton인스턴스
    private FirebaseAnalytics mFB_Analytics = null;    // 이벤트 추적에 사용할 에널리틱스 객체

    // Singleton 객체 get메소드
    // 넘겨주는 Context는 ApplicationContext를 넘겨 줄 것.(LifeCycle을 앱 실행부터 종료까지 유지해주기 위해)
    static public GA_EventTracker getInstance(Context applicationContext) {

        if (mSingletonInstance == null) {

            mSingletonInstance = new GA_EventTracker(applicationContext);
        }

        return mSingletonInstance;
    }

    // 생성자
    private GA_EventTracker(Context context) {

        mFB_Analytics = FirebaseAnalytics.getInstance(context);
    }

    // 추적 이벤트 송신 메소드
    public void sendEventLog(String eventName, Bundle eventBundle) {

        // 전달되는 bundle이 null이면 종료
        if (eventBundle == null)
            return;

        mFB_Analytics.logEvent(eventName, eventBundle);
    }

    // 추적 이벤트 송신 메소드
    public void sendEventLog(String eventName, String ePropertyName, String ePropertyValue) {

        // 전달 이벤트 이름이 없으면 종료
        if (eventName == null || eventName.length() <= 0)
            return;

        // 전달 이벤트 속성 이름이 없으면 종료
        if (ePropertyName == null || ePropertyName.length() <= 0)
            return;

        // 전달 이벤트 속성값이 없으면 종료
        if (ePropertyValue == null || ePropertyValue.length() <= 0)
            return;

        Bundle bundle = new Bundle();
        bundle.putString(ePropertyName, ePropertyValue);
        mFB_Analytics.logEvent(eventName, bundle);
    }

}
