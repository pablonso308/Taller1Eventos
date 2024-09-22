package com.example.saludoappjava;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

        // Recuperar y aplicar el color de fondo guardado
        int colorGuardado = Utilidades.obtenerColorGuardado(this);
        layoutConfiguracion.setBackgroundColor(colorGuardado);

        // Cambiar el color del fondo a rojo y guardarlo
        buttonColorRojo.setOnClickListener(v -> {
            layoutConfiguracion.setBackgroundColor(Color.RED);
            Utilidades.guardarColor(ConfiguracionActivity.this, Color.RED);
        });

        // Cambiar el color del fondo a azul y guardarlo
        buttonColorAzul.setOnClickListener(v -> {
            layoutConfiguracion.setBackgroundColor(Color.BLUE);
            Utilidades.guardarColor(ConfiguracionActivity.this, Color.BLUE);
        });

        // Cambiar el color del fondo a verde y guardarlo
        buttonColorVerde.setOnClickListener(v -> {
            layoutConfiguracion.setBackgroundColor(Color.GREEN);
            Utilidades.guardarColor(ConfiguracionActivity.this, Color.GREEN);
        });

        // Volver a la pantalla de inicio
        buttonVolverInicio.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
