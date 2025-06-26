package com.example.open_sourcepart2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.open_sourcepart2.LoginActivity
import com.example.open_sourcepart2.databinding.ActivityLoginBinding

class Firstpage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)



        val btnLogin = findViewById<Button>(R.id.button3)
        val btnGetStarted = findViewById<Button>(R.id.button4)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this, "Opening Login page", Toast.LENGTH_SHORT).show()
        }

        btnGetStarted.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
            Toast.makeText(this, "Opening Signup page", Toast.LENGTH_SHORT).show()
        }
    }
}