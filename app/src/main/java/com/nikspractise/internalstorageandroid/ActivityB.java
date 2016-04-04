package com.nikspractise.internalstorageandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Nikhil Bhutani on 4/4/2016.
 */
public class ActivityB extends Activity{
TextView username;
private static final String Default = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username = (TextView)findViewById(R.id.textView2);
    }

    public void load(View view)
    {
        FileInputStream fis = null;
       // if the data is read as -1, means that file is empty.
        try {
             fis = openFileInput("niks.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read = fis.read())!=-1)
            {
              buffer.append((char)read);
            }
            Log.d("Niks", buffer.toString());

            String text = buffer.substring(0, buffer.indexOf(" "));

            username.setText(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Toast.makeText(this, "Data is loaded", Toast.LENGTH_LONG).show();
    }


    public void previous(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
