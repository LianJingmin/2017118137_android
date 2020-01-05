package com.example.runtimepermissiontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button makeCall = (Button)findViewById(R.id.make_call);
        makeCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                   ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                           Manifest.permission.CALL_PHONE
                   },1);
               }else{
                   call();
               }
            }
        });
    }
    private void call(){
        try{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch(SecurityException e){
            e.printStackTrace();
        }
    }
    
    public void onRequestPermissionResult(int requestCode,String[] permissions,int[] grantResult){
        switch (requestCode){
            case 1:
                if(grantResult.length>0&&grantResult[0]==PackageManager.PERMISSION_GRANTED){
                    call();
                }else{
                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }
}
