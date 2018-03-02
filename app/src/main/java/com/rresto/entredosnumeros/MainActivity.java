package com.rresto.entredosnumeros;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //Constantes
    final static long delayMillis = 1000; //1 Segundos, tiempo en milisegundos

    //Variables
    NumberPicker minimalNumberPicker;
    NumberPicker maximalNumberPicker;
    ProgressBar progressBar;
    Button button;
    TextView numeroElegido;

    //Numero aleatorio
    //Random randNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos controles
        minimalNumberPicker = (NumberPicker) findViewById(R.id.minimalNumberPicker);
        maximalNumberPicker = (NumberPicker) findViewById(R.id.maximalNumberPicker);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        numeroElegido = (TextView) findViewById(R.id.textViewNumeroElegido);
        button = (Button) findViewById(R.id.button);

        //Ajustamos los controles
        minimalNumberPicker.setMinValue(1);
        minimalNumberPicker.setMaxValue(100);
        minimalNumberPicker.setValue(1);

        maximalNumberPicker.setMinValue(1);
        maximalNumberPicker.setMaxValue(100);
        maximalNumberPicker.setValue(100);

        progressBar.setVisibility(View.INVISIBLE);
        numeroElegido.setVisibility(View.INVISIBLE);

        //Inicializo el aleatorio
        //randNumber = new Random();

    }

    public void MyClickButton(View target) {

        /*
        //Elijo número aleatorio
        int rangoNumero = numberPicker.getValue();
        int numero = (int) (Math.random() *rangoNumero) + 1;
        */

        //Compruebo valores
        final int minimalNumber = minimalNumberPicker.getValue();
        final int maximalNumber = maximalNumberPicker.getValue();

        if (minimalNumber>=maximalNumber){
            Toast.makeText(this,R.string.errorMinimalEqualOrMayorMaximal,Toast.LENGTH_SHORT).show();
            return;
        }

        //Pongo pausa
        progressBar.setVisibility(View.VISIBLE);
        numeroElegido.setVisibility(View.INVISIBLE);
        button.setEnabled(false);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after long ms

                //Elijo número aleatorio
                //int rangoNumero = numberPicker.getValue();
                //int numero = (int) (Math.random() *rangoNumero) + 1;


                int rangoNumero = maximalNumber-minimalNumber+1;
                int numero = (int) (Math.random() * rangoNumero) + minimalNumber;


                //int numero = randNumber.nextInt((maximalNumber - minimalNumber) + 1) + minimalNumber;

                //int numero = ThreadLocalRandom.current().nextInt(minimalNumber, maximalNumber + 1);

                progressBar.setVisibility(View.INVISIBLE);

                //Activo el texto
                String stringNumeroElegido= getString (R.string.numeroElegido) + String.valueOf(numero);
                numeroElegido.setText(stringNumeroElegido);
                numeroElegido.setVisibility(View.VISIBLE);
                button.setEnabled(true);
            }
        }, delayMillis);

    }
}
