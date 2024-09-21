package com.example.saludoappjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipalActivity extends AppCompatActivity {

    // Declaración de las variables para los elementos de la interfaz
    private EditText editTextNombre;
    private TextView textViewNombreGuardado;
    private Button buttonGuardarNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Inicialización de los elementos de la interfaz
        editTextNombre = findViewById(R.id.editTextNombre);
        textViewNombreGuardado = findViewById(R.id.textViewNombreGuardado);
        buttonGuardarNombre = findViewById(R.id.buttonGuardarNombre);



        // Lógica para guardar el nombre y mostrarlo en el TextView
        buttonGuardarNombre.setOnClickListener(v -> {
            String nombreIngresado = editTextNombre.getText().toString(); // Obtener el nombre ingresado
            if (!nombreIngresado.isEmpty()) {
                textViewNombreGuardado.setText("Nombre: " + nombreIngresado); // Mostrar el nombre en el TextView
            } else {
                textViewNombreGuardado.setText("No se ingresó un nombre"); // Mostrar un mensaje si no hay nombre
            }
        });








    }
}