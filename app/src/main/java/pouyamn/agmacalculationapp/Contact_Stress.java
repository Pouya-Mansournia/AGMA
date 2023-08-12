package pouyamn.agmacalculationapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Contact_Stress extends AppCompatActivity {

    TextView DiameterCALCResult, CalcPowerTrans, CalcLineVolecity;
    EditText Np, Pd, Sigma, Ko, Qv, Kv, face, Km, Kb, I, Sp;
    Button Calc_BTN;
    Double Nteeth;
    Double Pichd;
    Double SIGMA;
    Double Svolecity;
    Double FACE;
    Double JIM;
    Double KO;
    Double KV;
    Double KM;
    Double KB;
    Double QV;
    float Diameter, linevolecity, Wt, Power, Akm, Bkm = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();

        init();

        Calc_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Snum1 = Np.getText().toString();
                Nteeth = Double.valueOf(Snum1);
                String Snum2 = Pd.getText().toString();
                Pichd = Double.valueOf(Snum2);
                Diameter = (float) (Nteeth / Pichd);
                DiameterCALCResult.setText(String.format("%.2f", Diameter));


                String Snum3 = Sp.getText().toString();
                Svolecity = Double.valueOf(Snum3);
                linevolecity = (float) ((3.1415 * Diameter * Svolecity) / (12));
                CalcLineVolecity.setText(String.format("%.2f", linevolecity));


//                Bkm = (float) (0.25 * (12 - QV) * 0.66);
//                Akm = (50 + (56 * (1 - Bkm)));
//                KV = Double.valueOf(((Akm + linevolecity) / (Akm)) * Bkm);

                String Snum7 = Ko.getText().toString();
                KO = Double.valueOf(Snum7);
                String Snum8 = Kv.getText().toString();
                KV = Double.valueOf(Snum8);
                String Snum10 = Km.getText().toString();
                KM = Double.valueOf(Snum10);
                String Snum11 = Kb.getText().toString();
                KB = Double.valueOf(Snum11);
                String Snum12 = Qv.getText().toString();
                QV = Double.valueOf(Snum12);


                String Snum4 = Sigma.getText().toString();
                SIGMA = Double.valueOf(Snum4);
                String Snum5 = face.getText().toString();
                FACE = Double.valueOf(Snum5);
                String Snum6 = I.getText().toString();
                JIM = Double.valueOf(Snum6);
                Wt = (float) ((SIGMA * FACE * JIM) / (KO * KV * 1 * Pichd * KM * KB));
                Power = (float) ((Wt * linevolecity) / 33000);
                CalcPowerTrans.setText(String.format("%.2f", Power));
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    public void init() {

        Np = (EditText) findViewById(R.id.ET0);
        Pd = (EditText) findViewById(R.id.ET1);
        Sigma = (EditText) findViewById(R.id.ET3);
        Ko = (EditText) findViewById(R.id.ET4);
        Qv = (EditText) findViewById(R.id.ET5);
        Kv = (EditText) findViewById(R.id.ET6);
        face = (EditText) findViewById(R.id.ET7);
        Km = (EditText) findViewById(R.id.ET8);
        Kb = (EditText) findViewById(R.id.ET9);
        I = (EditText) findViewById(R.id.ET10);
        Sp = (EditText) findViewById(R.id.ET11);

        Calc_BTN = (Button) findViewById(R.id.button_Calc);
        DiameterCALCResult = (TextView) findViewById(R.id.TVV2);
        CalcPowerTrans = (TextView) findViewById(R.id.TV12);
        CalcLineVolecity = (TextView) findViewById(R.id.TV14);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

