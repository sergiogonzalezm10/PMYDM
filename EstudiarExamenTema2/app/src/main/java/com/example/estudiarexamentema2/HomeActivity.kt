package com.example.estudiarexamentema2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val TAG = "CicloDeVida"
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

        Log.d(TAG, "B: onCreate creado")

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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "B: onStart llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "B: onResume llamado ¡La Activity es visible y activa!")

        // Toast requerido usando getString()
        Toast.makeText(applicationContext, getString(R.string.toast_actividad_b), Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "B: onPause llamado Otra Activity toma el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "B: onStop llamado La Activity ya no es visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "B: onRestart llamado Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "B: onDestroy llamado La Activity está siendo destruida")
    }
}