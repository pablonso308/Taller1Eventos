package com.example.saludoappjava;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ConfiguracionActivity extends AppCompatActivity {

    private LinearLayout layoutConfiguracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        // Inicializar las vistas
        layoutConfiguracion = findViewById(R.id.layoutConfiguracion);
        Button buttonColorRojo = findViewById(R.id.buttonColorRojo);
        Button buttonColorVerde = findViewById(R.id.buttonColorVerde);
        Button buttonColorAzul = findViewById(R.id.buttonColorAzul);
        Button buttonVolverInicio = findViewById(R.id.buttonVolverInicio);

        // Manejar selección de color para cambiar el fondo
        buttonColorRojo.setOnClickListener(v -> cambiarColorDeFondo(ContextCompat.getColor(this, android.R.color.holo_red_light)));
        buttonColorVerde.setOnClickListener(v -> cambiarColorDeFondo(ContextCompat.getColor(this, android.R.color.holo_green_light)));
        buttonColorAzul.setOnClickListener(v -> cambiarColorDeFondo(ContextCompat.getColor(this, android.R.color.holo_blue_light)));

        // Volver a la pantalla principal (MainActivity)
        buttonVolverInicio.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    // Método para cambiar el color del fondo y guardarlo en SharedPreferences
    private void cambiarColorDeFondo(int color) {
        layoutConfiguracion.setBackgroundColor(color);  // Cambiar el color en la vista actual
        Utilidades.guardarColorFondo(this, color);  // Guardar el color seleccionado
    }
}
