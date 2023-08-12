package pouyamn.agmacalculationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AGMA_SPLASH extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        Thread time_control = new Thread() {
            public void run() {

                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent open_activity = new Intent("android.intent.action.CALCPAGE");
                    startActivity(open_activity);

                }
            }


        };
        time_control.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
