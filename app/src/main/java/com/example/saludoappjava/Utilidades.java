package com.example.saludoappjava;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

public class Utilidades {

    private static final String PREFERENCIAS_COLOR = "PreferenciasColor";
    private static final String CLAVE_COLOR = "color_fondo";

    // Método para obtener el color guardado
    public static int obtenerColorGuardado(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS_COLOR, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(CLAVE_COLOR, Color.WHITE); // Blanco por defecto
    }

    // Método para guardar el color en las preferencias
    public static void guardarColor(Context context, int color) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS_COLOR, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CLAVE_COLOR, color);
        editor.apply(); // Guardar los cambios
    }
}
