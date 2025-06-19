package com.czy.helloworldandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.czy.helloworldandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (username == "admin" && password == "123") {
                Toast.makeText(this, "Username: $username, Password: $password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

//        val textView = findViewById<TextView>(R.id.textHello)
//        textView.setText("Halo Android")
//        var editTextUsername = findViewById<TextView>(R.id.editTextUsername)
//        var editTextPassword = findViewById<TextView>(R.id.editTextPassword)
//        var btnLogin: Button = findViewById<Button>(R.id.buttonLogin)
//        btnLogin.setOnClickListener {
//            val username = editTextUsername.text.toString()
//            val password = editTextPassword.text.toString()
//            if (username == "admin" && password == "123") {
//                Toast.makeText(this, "Username: $username, Password: $password", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}