package com.example.saludoappjava;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipalActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private TextView textViewNombreGuardado;
    private TextView textViewProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Inicializar vistas
        editTextNombre = findViewById(R.id.editTextNombre);
        textViewNombreGuardado = findViewById(R.id.textViewNombreGuardado);
        textViewProgreso = findViewById(R.id.textViewProgreso);
        Button buttonGuardarNombre = findViewById(R.id.buttonGuardarNombre);
        Button buttonIniciarTarea = findViewById(R.id.buttonIniciarTarea);
        Button buttonVolverMain = findViewById(R.id.buttonVolverMain);

        // Guardar el nombre ingresado y mostrarlo en el TextView
        buttonGuardarNombre.setOnClickListener(v -> {
            String nombre = editTextNombre.getText().toString().trim();

            if (!nombre.isEmpty()) {
                textViewNombreGuardado.setText("Nombre: " + nombre);
                Toast.makeText(PantallaPrincipalActivity.this, "Nombre guardado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PantallaPrincipalActivity.this, "Por favor, ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
        });

        // Iniciar la tarea en segundo plano al presionar el botón
        buttonIniciarTarea.setOnClickListener(v -> {
            new SimulacionRedTask().execute();
        });

        // Volver a la pantalla principal (MainActivity) al presionar el botón
        buttonVolverMain.setOnClickListener(v -> {
            // Finalizar esta actividad y volver al MainActivity
            finish();
        });
    }

    // AsyncTask para simular una operación de red en segundo plano
    private class SimulacionRedTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            // Antes de iniciar la tarea, mostrar el progreso en 0%
            textViewProgreso.setText("Progreso: 0%");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Simular operación de red que tarda 5 segundos, con progreso en intervalos
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000);  // Simular un retraso de 1 segundo
                    publishProgress(i * 20);  // Actualizar el progreso (20%, 40%, 60%, 80%, 100%)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // Actualizar el TextView con el progreso
            int progreso = values[0];
            textViewProgreso.setText("Progreso: " + progreso + "%");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Al finalizar la tarea, mostrar un mensaje de completado
            Toast.makeText(PantallaPrincipalActivity.this, "Tarea completada", Toast.LENGTH_SHORT).show();
        }
    }
}

