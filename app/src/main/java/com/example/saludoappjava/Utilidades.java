package com.example.saludoappjava;


import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.content.ContextCompat;

public class Utilidades {
    private static final String PREFERENCIAS = "ConfiguracionApp";
    private static final String CLAVE_COLOR_FONDO = "colorFondo";

    // Guardar el color de fondo seleccionado
    public static void guardarColorFondo(Context context, int color) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CLAVE_COLOR_FONDO, color);
        editor.apply();
    }

    // Obtener el color de fondo guardado, o un color por defecto si no se ha guardado
    public static int obtenerColorGuardado(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        return prefs.getInt(CLAVE_COLOR_FONDO, ContextCompat.getColor(context, android.R.color.white));  // Por defecto blanco
    }
}
