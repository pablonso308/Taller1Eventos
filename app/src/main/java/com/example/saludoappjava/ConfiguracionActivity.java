package com.example.saludoappjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConfiguracionActivity extends AppCompatActivity {

    private ConstraintLayout layoutConfiguracion;
    private Button buttonColorRojo;
    private Button buttonColorAzul;
    private Button buttonColorVerde;
    private Button buttonVolverInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        // Inicializar las vistas
        layoutConfiguracion = findViewById(R.id.layoutConfiguracion);
        buttonColorRojo = findViewById(R.id.buttonColorRojo);
        buttonColorAzul = findViewById(R.id.buttonColorAzul);
        buttonColorVerde = findViewById(R.id.buttonColorVerde);
        buttonVolverInicio = findViewById(R.id.buttonVolverInicio);

        // Cambiar el color del fondo a rojo
        buttonColorRojo.setOnClickListener(v -> layoutConfiguracion.setBackgroundColor(Color.RED));

        // Cambiar el color del fondo a azul
        buttonColorAzul.setOnClickListener(v -> layoutConfiguracion.setBackgroundColor(Color.BLUE));

        // Cambiar el color del fondo a verde
        buttonColorVerde.setOnClickListener(v -> layoutConfiguracion.setBackgroundColor(Color.GREEN));

        // Volver a la pantalla de inicio
        buttonVolverInicio.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
