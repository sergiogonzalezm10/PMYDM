package com.example.estudiarexamentema2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudiarexamentema2.databinding.ActivityAccesosBinding

class AccesosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccesosBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAccesosBinding.inflate(layoutInflater)
        setContentView(binding.root)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            binding.buttonNavegador.setOnClickListener {
                val query = binding.editTextTextEntrada.text.toString()
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = "https://www.google.com/search?q=$query".toUri()
                startActivity(intent)
            }
            binding.buttonTelefono.setOnClickListener {
                val query = binding.editTextTextEntrada.text.toString()
                if (query.isEmpty()) {
                    binding.editTextTextEntrada.error = "Escribe algo para poder acceder a los accesorios"
                    return@setOnClickListener
                }
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = "tel:$query".toUri()
                    startActivity(intent)
            }

            binding.buttonSMS.setOnClickListener {
                val smsIntent = Intent(Intent.ACTION_VIEW)
                smsIntent.data = Uri.parse("smsto:" + binding.editTextTextEntrada.text.toString()) // número escrito en el EditText
                smsIntent.putExtra("sms_body", "Hola desde mi app") // texto opcional
                startActivity(smsIntent)
            }

            binding.buttonCompartir.setOnClickListener {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, binding.editTextTextEntrada.text.toString()) // texto escrito en el EditText
                startActivity(Intent.createChooser(shareIntent, "Compartir con..."))

            }

            binding.buttonVolverHome.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }