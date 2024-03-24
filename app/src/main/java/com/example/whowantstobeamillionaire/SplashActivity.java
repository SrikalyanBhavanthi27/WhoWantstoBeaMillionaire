package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay for 2 seconds (2000 milliseconds) before starting Question1Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start Question1Activity after the delay
                Intent intent = new Intent(SplashActivity.this,Question1Activity.class);
                startActivity(intent);
                finish(); // Optional: Finish the splash activity to prevent it from appearing in the back stack
            }
        }, 2000); // 2000 milliseconds = 2 seconds
    }
}
