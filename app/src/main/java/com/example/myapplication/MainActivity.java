package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText dlugosc_wprowadzona, masa_wprowadzona;
    private TextView dlugosc_wychodzaca, masa_wychodzaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlugosc_wprowadzona = findViewById(R.id.input_value_length);
        masa_wprowadzona = findViewById(R.id.input_value_mass);
        dlugosc_wychodzaca = findViewById(R.id.output_text_length);
        masa_wychodzaca = findViewById(R.id.output_text_mass);

        Button convertButtonLength = findViewById(R.id.convert_button_length);
        Button convertButtonMass = findViewById(R.id.convert_button_mass);

        // ------przycisk dlugosci--------
        convertButtonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });

        // --------przycisk masy----------
        convertButtonMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertMass();
            }

        });
    }
    
    
    

    // ----konwerter dlugosci-------
    private void convertLength() {
        String wynikk = dlugosc_wprowadzona.getText().toString();
        if (wynikk.isEmpty()) {
            dlugosc_wychodzaca.setText("Wprowadź wartość!");
            return;
        }

        double metry = Double.parseDouble(wynikk);

        // ----przeliczanie-------
        double kilometers = metry / 1000;
        double mile = metry * 0.000621371;
        double cale = metry * 39.3701;

        // ------wyswietlanie---------
        String wynik = "Kilometry: " + kilometers + "\n"
                + "Mile: " + mile + "\n"
                + "Cale: " + cale;

        dlugosc_wychodzaca.setText(wynik);
    }
    
    
    
    

    // --------konwerter masy--------
    private void convertMass() {
        String wynikk = masa_wprowadzona.getText().toString();
        if (wynikk.isEmpty()) {
            masa_wychodzaca.setText("Wprowadź wartość!");
            return;
        }

        double kilo = Double.parseDouble(wynikk);

        
        double funty = kilo * 2.20462;
        double uncje = kilo * 35.274;


        String wynik = "Funty: " + funty + "\n"
                + "Uncje: " + uncje;

        masa_wychodzaca.setText(wynik);
    }

}