package com.example.estudiarexamentema2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var contrasenaGuardada: String = "1234" // Contraseña por defecto
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonLogin.setOnClickListener {
            val usuario = binding.editTextTextName.text.toString()
            val contraseña = binding.editTextTextPassword.text.toString()

            if ( usuario.isEmpty() || contraseña.isEmpty()) {
                binding.editTextTextName.error = "Escribe un nombre de usuario para poder acceder"
                binding.editTextTextPassword.error = "Escribe una contraseña correcta para poder acceder"
                return@setOnClickListener
            } else if ( usuario == "admin" && contraseña == contrasenaGuardada) {
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("usuario", usuario)
                }
                startActivity(intent)
            } else {
                val intent = Intent(this, ErrorActivity::class.java).apply {
                    putExtra("usuario", usuario)
                }
                startActivity(intent)
            }
        }
    }
}