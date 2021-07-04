package com.example.areuokey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;

import android.content.pm.PackageManager;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Message extends AppCompatActivity {

    EditText textbox;
    Button savebtn;
    String mText;
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        textbox = findViewById(R.id.textbox);
        savebtn = findViewById(R.id.savebtn);


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText = textbox.getText().toString().trim();
                if (mText.isEmpty()) {
                    Toast.makeText(Message.this, "Pleaste enter something", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED){
                            String[] permisssion = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                            requestPermissions(permisssion,WRITE_EXTERNAL_STORAGE_CODE);
                        }
                        else {
                            saveToTxtFile(mText);
                        }
                    }
                    else {
                        saveToTxtFile(mText);
                    }
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0]
                        == PackageManager.PERMISSION_DENIED) {
                    saveToTxtFile(mText);
                } else {
                    Toast.makeText(this, "Storage permission is required to store data", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void saveToTxtFile(String mText) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());
        try {
           File path = Environment.getExternalStorageDirectory();
           File dir = new File(path + "My Files");
           dir.mkdir();
           String fileName = "MyFile_" + timeStamp + ".txt";
           File file = new File(dir, fileName);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();

            Toast.makeText(this, fileName+"is save to\n" +dir, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}


