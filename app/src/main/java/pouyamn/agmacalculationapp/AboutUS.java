package pouyamn.agmacalculationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AboutUS extends AppCompatActivity {
    Button tell, web, telegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        init();

        tell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_tell = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+989384198683"));
                startActivity(call_tell);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://Mailto:p.mansournia@gmail.com"));
                startActivity(call_web);
            }
        });

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_telegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/Pouya_MnS"));
                startActivity(call_telegram);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void init() {
        tell = (Button) findViewById(R.id.btn_tell);
        web = (Button) findViewById(R.id.btn_mail);
        telegram = (Button) findViewById(R.id.btn_telegram);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_Bending_stress) {
            Intent open_activity = new Intent("android.intent.action.CALCPAGE");
            startActivity(open_activity);
        }
        if (id == R.id.action_Contact_Stress) {
            Intent open_activity = new Intent("android.intent.action.CONTACTSS");
            startActivity(open_activity);
        }
        if (id == R.id.action_about_us) {
            Intent open_activity = new Intent("android.intent.action.aboutus");
            startActivity(open_activity);
        }
        if (id == R.id.action_logout) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
