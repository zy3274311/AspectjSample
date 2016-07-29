package com.qihoo.aspectjsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qihoo.aspectjlibrary.DebugTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log();
    }

    @DebugTrace
    private void log(){
        Log.e("MainActivity", "MainActivity onCreate");
    }
}
