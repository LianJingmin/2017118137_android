package com.example.theone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG="Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("thetwo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }@Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }@Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }@Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }@Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

}
