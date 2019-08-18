package com.example.uploader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar circular,horizontal;
    Button begin,stop,upload_data;

    int progress = 0;
    final int rec=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circular = findViewById(R.id.circular_progressBar);
        horizontal = findViewById(R.id.hori_progressBar);

        begin = findViewById(R.id.start_button);
        stop = findViewById(R.id.End_button);
        upload_data = findViewById(R.id.Upload_button);

        circular.setVisibility(View.GONE);
    }

    public void start(View view){

        circular.setVisibility(View.VISIBLE);
    }

    public void end(View view){

        circular.setVisibility(View.GONE);

    }

    public void upload(View view){

        Toast.makeText(this, "Uploading please wait", Toast.LENGTH_SHORT).show();
        fakeProgress(progress);


    }

    public boolean fakeProgress(final int progress) {

        horizontal.setProgress(progress);

        if (progress < 100) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    fakeProgress(progress + 10);
                }


            });
            thread.start();

        }
        else{
            return false;
    }

        return(true);
    }

}
