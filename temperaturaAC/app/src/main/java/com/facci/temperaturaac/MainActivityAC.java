package com.facci.temperaturaac;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.Locale;


public class MainActivityAC extends AppCompatActivity {


    double recTemp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ac);

        final TextView recTempTV = (TextView) findViewById(R.id.recTempTV);
        final TextView farTV = (TextView) findViewById(R.id.farTV);
        final TextView kelTV = (TextView) findViewById(R.id.kelTV);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(3000);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                recTemp = (double) (progress/10.0);
                String texto = FormatNumber (progress/10.0);
                texto += " °C";
                recTempTV.setText(texto);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Button convertirBT = (Button) findViewById(R.id.convertirBT);

        convertirBT.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                double farenheit = (((recTemp)*9/5)+32);
                String texto = FormatNumber(farenheit);
                texto += " °F";
                farTV.setText(texto);

                double Kelvin = (recTemp + 273);
                String texto2 = FormatNumber(Kelvin);
                texto += " °K";
                kelTV.setText(texto2);
            }
        });

    }

    private String FormatNumber(double valor){
        return String.format(Locale.FRANCE,"%.2f", valor);
    }
}
