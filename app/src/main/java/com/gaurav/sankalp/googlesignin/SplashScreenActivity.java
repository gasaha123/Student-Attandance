package com.gaurav.sankalp.googlesignin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMER =  1250;
    private SharedPrefManager sharedPrefManager;
    private static final int LOGIN = 2;
    private static final int DASHBOARD = 3;
    private int destinationFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        destinationFlag = getDestinationActivity();
        doTheDelayStuff();

    }


    private void doTheDelayStuff() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (destinationFlag){
                    case DASHBOARD:
                        moveToDirectiveActivity();
                        break;
                    case LOGIN:
                        moveToLoginPage();
                        break;

                }
            }
        }, SPLASH_SCREEN_TIMER);
    }

    private int getDestinationActivity(){
        sharedPrefManager = new SharedPrefManager(this);

            if (sharedPrefManager.isLoggedIn()){
                return DASHBOARD;
            } else {
                return LOGIN;
            }

    }

    private void moveToLoginPage() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void moveToDirectiveActivity() {
        startActivity(new Intent(this, DirectiveActivity.class));
        finish();
    }


}
