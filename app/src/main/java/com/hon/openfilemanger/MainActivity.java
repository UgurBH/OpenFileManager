package com.hon.openfilemanger;

import androidx.appcompat.app.AppCompatActivity;
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

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        } else {
            Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
        }

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(openFile);


    }

    View.OnClickListener openFile = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openFileBrowser();
        }
    };

    private void openFileBrowser(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse("/Downloads/");
        intent.setDataAndType(uri, "*/*");
        startActivity(intent);
    }
}