package com.example.saludoappjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        layoutMain = findViewById(R.id.layoutMain);
        TextView textViewSaludo = findViewById(R.id.textViewSaludo);
        Button buttonSiguiente = findViewById(R.id.buttonSiguiente);
        Button buttonAbrirConfiguracion = findViewById(R.id.buttonAbrirConfiguracion);

        // Recuperar y aplicar el color de fondo guardado
        int colorGuardado = Utilidades.obtenerColorGuardado(this);
        layoutMain.setBackgroundColor(colorGuardado);

        // Obtener la hora actual para mostrar un saludo personalizado
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String saludo;
        if (hour >= 6 && hour < 12) {
            saludo = "Buenos días";
        } else if (hour >= 12 && hour < 18) {
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }
        textViewSaludo.setText(saludo);

        // Navegar a la pantalla principal cuando se presiona el botón
        buttonSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantallaPrincipalActivity.class);
            startActivity(intent);
        });

        // Abrir la configuración cuando se presiona el botón de configuración
        buttonAbrirConfiguracion.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
            startActivity(intent);
        });
    }
}
