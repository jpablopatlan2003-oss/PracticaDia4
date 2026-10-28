package com.example.practicadia4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Etiqueta (TAG) para identificar los mensajes en la pestaña Logcat
    private val TAG = "CONVERSOR_APP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Vincular los elementos de la interfaz usando findViewById
        val etCelsius = findViewById<EditText>(R.id.etCelsius)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // 2. Configurar el evento de clic en el botón (ClickListener)
        btnConvertir.setOnClickListener {
            val textoIngresado = etCelsius.text.toString()

            // Registro en Logcat para verificar la lectura
            Log.d(TAG, "Texto ingresado en el campo: '$textoIngresado'")

            // 3. Validación: Comprobar si el campo está vacío
            if (textoIngresado.isEmpty()) {
                Log.w(TAG, "Intento de conversión con campo vacío")

                // Mostrar mensaje emergente (Toast)
                Toast.makeText(this, "⚠️ Por favor, ingresa una temperatura", Toast.LENGTH_SHORT).show()

                tvResultado.text = "Resultado: -- °F"
            } else {
                // 4. Convertir el texto a un número decimal (Double)
                val celsius = textoIngresado.toDouble()

                // 5. Aplicar la fórmula matemática: (°C × 9/5) + 32
                val fahrenheit = (celsius * 9 / 5) + 32

                // Log informativo de la conversión exitosa
                Log.i(TAG, "Conversión realizada: $celsius °C -> $fahrenheit °F")

                // 6. Actualizar el TextView en la pantalla
                tvResultado.text = "Resultado: %.1f °F".format(fahrenheit)

                // 7. Notificación flotante de éxito
                Toast.makeText(this, "¡Conversión realizada con éxito!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}