package com.example.coronaapivirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        String imageURL="https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=b296fcbc2dmsh6bfe7d8930db773p1e098ajsnf3c04b17ca0e";

        ImageView image=findViewById(R.id.imageReq);
        ImageRequest imageReq=new ImageRequest(image);
        imageReq.execute(imageURL);

        /*
        new ImageRequest((ImageView) findViewById(R.id.imageReq))
                .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=b296fcbc2dmsh6bfe7d8930db773p1e098ajsnf3c04b17ca0e");
        */

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(20000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
