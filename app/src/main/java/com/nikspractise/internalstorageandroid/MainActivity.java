package com.nikspractise.internalstorageandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.username);

    }

    public void save(View view)
    {
        String text = userName.getText().toString();
        text = text+" ";
        FileOutputStream fos = null;
                //FileOutputStream is a java object that is responsible for writing data to files.
        File file = null;
        try {
            file = getFilesDir();
            fos = openFileOutput("niks.txt", Context.MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
                e.printStackTrace();
            }
        finally {
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,"Saved Successfully "+file+" /niks.txt", Toast.LENGTH_SHORT).show();
    }

    public void next(View view)
    {
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);
    }

}
