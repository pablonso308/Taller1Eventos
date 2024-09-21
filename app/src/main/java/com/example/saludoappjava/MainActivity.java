package com.example.saludoappjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia al TextView donde se mostrará el saludo
        TextView textViewSaludo = findViewById(R.id.textViewSaludo);
        Button buttonSiguiente = findViewById(R.id.buttonSiguiente);

        // Obtener la hora actual
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // Determinar el saludo según la hora del día
        String saludo;
        if (hour >= 6 && hour < 12) {
            saludo = "Buenos días";
        } else if (hour >= 12 && hour < 18) {
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }

        // Mostrar el saludo en el TextView
        textViewSaludo.setText(saludo);

        // Navegar a la pantalla principal cuando se presiona el botón
        buttonSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantallaPrincipalActivity.class);
            startActivity(intent);
        });
    }
}
