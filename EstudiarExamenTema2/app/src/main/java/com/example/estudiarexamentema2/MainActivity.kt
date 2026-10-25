package com.example.estudiarexamentema2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "CiclodeVida"
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

        Log.d(TAG, "onCreate: La pantalla de Login se ha creado")
        Toast.makeText(applicationContext, getString(R.string.titulo_actividad_a), Toast.LENGTH_SHORT).show()

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
                Toast.makeText(applicationContext, "Ir a la actividad B", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                val intent = Intent(this, ErrorActivity::class.java).apply {
                    putExtra("usuario", usuario)
                }
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: La pantalla de Login se ha iniciado y es visible")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La pantalla de Login está activa y lista para interactuar")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: El Login ha perdido el foco (se está abriendo otra Activity)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: El Login ya no es visible en pantalla")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: El usuario vuelve a la pantalla de Login")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: La pantalla de Login se ha destruido de la memoria")
    }
}