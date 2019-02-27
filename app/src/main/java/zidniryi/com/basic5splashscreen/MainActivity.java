package zidniryi.com.basic5splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    //todo atribute pewaktu
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Thread
        Thread mythread = new Thread(){
            public  void run(){
                try {
                    while (splashActive&&ms < splashTime){
                        if (!paused){
                            ms = ms + 100;
                            sleep(100);
                        }

                    }
                }catch (Exception e){

                }finally {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }


            }

        };

        //Menjalankan
        mythread.start();

    }
}
