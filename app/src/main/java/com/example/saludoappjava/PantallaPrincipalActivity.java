package com.example.saludoappjava;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PantallaPrincipalActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private TextView textViewNombreGuardado;
    private TextView textViewProgreso;
    private ConstraintLayout layoutPantallaPrincipal;  // El layout principal de la actividad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Inicializar las vistas
        editTextNombre = findViewById(R.id.editTextNombre);
        textViewNombreGuardado = findViewById(R.id.textViewNombreGuardado);
        textViewProgreso = findViewById(R.id.textViewProgreso);
        Button buttonGuardarNombre = findViewById(R.id.buttonGuardarNombre);
        Button buttonIniciarTarea = findViewById(R.id.buttonIniciarTarea);
        layoutPantallaPrincipal = findViewById(R.id.layoutPantallaPrincipal);

        // Recuperar y aplicar el color de fondo guardado
        int colorGuardado = Utilidades.obtenerColorGuardado(this);
        layoutPantallaPrincipal.setBackgroundColor(colorGuardado);

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
