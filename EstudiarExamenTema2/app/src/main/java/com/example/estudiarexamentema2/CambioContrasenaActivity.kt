package com.example.estudiarexamentema2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityCambioContrasenaBinding
class CambioContrasenaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCambioContrasenaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCambioContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nuevaContrasena = binding.editTextTextPassword2.text.toString().trim()
        if (nuevaContrasena.isNotEmpty()) {
            MainActivity.contrasenaGuardada = nuevaContrasena // 👈 Cambia el valor global

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 1. Botón para cambiar la contraseña
        binding.buttonGuardarContraseA.setOnClickListener {
            val nuevaContrasena = binding.editTextTextPassword2.text.toString().trim()

            if (nuevaContrasena.isNotEmpty()) {
                // Cambiamos el valor global
                MainActivity.contrasenaGuardada = nuevaContrasena

                // Mostramos el mensaje en el TextView en lugar de cambiar de pantalla
                binding.textView3.text = "¡Contraseña cambiada exitosamente!"
            } else {
                binding.editTextTextPassword2.error = "Escribe una contraseña válida"
            }
        }

        // 2. Botón para volver manualmente al Login (MainActivity)
        binding.buttonVolverLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}