package com.example.estudiarexamentema2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usuario = intent.getStringExtra("usuario") ?: "Usuario"
        binding.TextBienvenida.text = "¡Bienvenido, $usuario!"

        binding.buttonAcceder.setOnClickListener {
            val intent = Intent(this, AccesosActivity::class.java)
            startActivity(intent)
        }

        binding.buttonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonCambiarContraseA.setOnClickListener {
            val intent = Intent(this, CambioContrasenaActivity::class.java)
            startActivity(intent)
        }
    }
}