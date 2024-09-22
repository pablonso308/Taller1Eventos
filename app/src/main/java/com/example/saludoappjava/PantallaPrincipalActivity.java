package com.example.saludoappjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PantallaPrincipalActivity extends AppCompatActivity {

    // Declaración de las variables para los elementos de la interfaz
    private EditText editTextNombre;
    private TextView textViewNombreGuardado;
    private Button buttonGuardarNombre;
    private Button buttonIrConfiguracion;
    private ConstraintLayout layoutPantallaPrincipal; // Layout de la pantalla principal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Inicialización de los elementos de la interfaz
        layoutPantallaPrincipal = findViewById(R.id.layoutPantallaPrincipal); // El layout principal
        editTextNombre = findViewById(R.id.editTextNombre);
        textViewNombreGuardado = findViewById(R.id.textViewNombreGuardado);
        buttonGuardarNombre = findViewById(R.id.buttonGuardarNombre);
        buttonIrConfiguracion = findViewById(R.id.buttonIrConfiguracion); // Inicializamos el nuevo botón

        // Recuperar y aplicar el color de fondo guardado
        int colorGuardado = Utilidades.obtenerColorGuardado(this);
        layoutPantallaPrincipal.setBackgroundColor(colorGuardado);


        // Lógica para guardar el nombre y mostrarlo en el TextView
        buttonGuardarNombre.setOnClickListener(v -> {
            String nombreIngresado = editTextNombre.getText().toString(); // Obtener el nombre ingresado
            if (!nombreIngresado.isEmpty()) {
                textViewNombreGuardado.setText("Nombre: " + nombreIngresado); // Mostrar el nombre en el TextView
            } else {
                textViewNombreGuardado.setText("No se ingresó un nombre"); // Mostrar un mensaje si no hay nombre
            }
        });

        // Lógica para ir a ConfiguracionActivity al hacer clic en el nuevo botón
        buttonIrConfiguracion.setOnClickListener(v -> {
            Intent intent = new Intent(PantallaPrincipalActivity.this, ConfiguracionActivity.class);
            startActivity(intent); // Iniciar la actividad de configuración
        });







    }
}