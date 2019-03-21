package com.example.testtttttt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
     VideoView video;
    @Override
    protected void onResume() {
        super.onResume();
        video.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.intro);
        video.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         video = findViewById(R.id.video);
                video.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.intro);
                video.start();
                video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        video.start();
                    }
                });
        Button start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent  = new Intent(getApplicationContext(),ChooseBrand.class);
                startActivity(intent);
            }
        });
    }

}
