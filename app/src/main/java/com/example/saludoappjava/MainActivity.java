package com.example.saludoappjava;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layoutMain;
    private TextView textViewSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        layoutMain = findViewById(R.id.layoutMain);
        textViewSaludo = findViewById(R.id.textViewSaludo);
        Button buttonSiguiente = findViewById(R.id.buttonSiguiente);

        // Recuperar y aplicar el color de fondo guardado
        int colorGuardado = Utilidades.obtenerColorGuardado(this);
        layoutMain.setBackgroundColor(colorGuardado);

        // Ejecutar AsyncTask para calcular el saludo
        new SaludoTask().execute();

        // Navegar a la pantalla principal cuando se presiona el botón
        buttonSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantallaPrincipalActivity.class);
            startActivity(intent);
        });
    }

    // AsyncTask para manejar el cálculo del saludo en segundo plano
    private class SaludoTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            return obtenerSaludoPersonalizado();
        }

        @Override
        protected void onPostExecute(String saludo) {
            // Mostrar el saludo en el TextView
            textViewSaludo.setText(saludo);
        }

        private String obtenerSaludoPersonalizado() {
            // Obtener la hora actual
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            // Determinar el saludo según la hora del día
            if (hour >= 6 && hour < 12) {
                return "Buenos días";
            } else if (hour >= 12 && hour < 18) {
                return "Buenas tardes";
            } else {
                return "Buenas noches";
            }
        }
    }
}
