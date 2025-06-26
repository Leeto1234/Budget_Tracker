package com.example.open_sourcepart2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.open_sourcepart2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        sessionManager = SessionManager(this)

        // If user is already logged in, go to MainActivity
        if (sessionManager.isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateInputs(email, password)) {
                val user = databaseHelper.getUser(email, password)
                if (user != null) {
                    sessionManager.createLoginSession(user)

                    // Launch MainActivity
                    startActivity(Intent(this, MainActivity::class.java))



                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        // Social login (optional placeholders)
        binding.ivGoogle.setOnClickListener {
            Toast.makeText(this, "Google login not implemented", Toast.LENGTH_SHORT).show()
        }
        binding.ivGithub.setOnClickListener {
            Toast.makeText(this, "GitHub login not implemented", Toast.LENGTH_SHORT).show()
        }
        binding.ivFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook login not implemented", Toast.LENGTH_SHORT).show()
        }
        binding.ivInstagram.setOnClickListener {
            Toast.makeText(this, "Instagram login not implemented", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        var isValid = true

        if (email.isEmpty()) {
            binding.tilEmail.error = "Email cannot be empty"
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        if (password.isEmpty()) {
            binding.tilPassword.error = "Password cannot be empty"
            isValid = false
        } else {
            binding.tilPassword.error = null
        }

        return isValid
    }
}
