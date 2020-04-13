package android.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class add_alarm extends AppCompatActivity {
    private CheckBox mon, tue, wed, thurs, fri, sat, sun;
    private Button btSubmit;
    boolean check = false;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        final TimePicker tp = (TimePicker) findViewById(R.id.tp);
        Button btn = (Button) findViewById(R.id.btn);
        tv1 = findViewById(R.id.tv1);
        mon = (CheckBox) findViewById(R.id.mon);
        tue = (CheckBox) findViewById(R.id.tue);
        wed = (CheckBox) findViewById(R.id.wed);
        thurs = (CheckBox) findViewById(R.id.thurs);
        fri = (CheckBox) findViewById(R.id.fri);
        sat = (CheckBox) findViewById(R.id.sat);
        sun = (CheckBox) findViewById(R.id.sun);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                int hourOfDay = tp.getCurrentHour(); //Get TimePicker current hour
                int minute = tp.getCurrentMinute(); //Get TimePicker current minute

                //Display the TimePicker current time to app interface
                String AMPM = "AM";
                if (hourOfDay > 11) {
                    //Get the current hour as AM PM 12 hour format
                    hourOfDay = hourOfDay - 12;
                    AMPM = "PM";
                }
                tv.setText("" + hourOfDay + ":" + minute + ":" + AMPM);
                if (mon.isChecked())
                    msg = msg + " Mon, ";
                if (tue.isChecked())
                    msg = msg + " Tue, ";
                if (wed.isChecked())
                    msg = msg + " Wed, ";
                if (thurs.isChecked())
                    msg = msg + " Thur, ";
                if (fri.isChecked())
                    msg = msg + " Fri, ";
                if (sat.isChecked())
                    msg = msg + " Sat, ";
                if (sun.isChecked())
                    msg = msg + " Sun, ";
                tv1.setText(msg);
            }
        });
    }
}

