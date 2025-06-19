package com.czy.helloworldandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.czy.helloworldandroid.databinding.ActivityMainRequestBinding

class MainRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainRequestBinding
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Set click listener for the button
        binding.buttonStartRequest.setOnClickListener {
            viewModel.fetchUsers()
        }

        // Observe users LiveData
        viewModel.users.observe(this) { users ->
            val textData = users.joinToString(separator = "\n") { user ->
                "ID: ${user.id}, First Name: ${user.firstName}, " +
                        "Last Name: ${user.lastName}, University: ${user.university}"
            }
            binding.TextView.text = textData.ifEmpty { "No data available" }
        }

        // Observe error LiveData
        viewModel.error.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}