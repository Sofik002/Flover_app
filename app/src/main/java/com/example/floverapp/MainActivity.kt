package com.example.floverapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.floverapp.R.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val label = findViewById<TextView>(id.flover_main)
        val buttonIn: Button = findViewById(id.button_in)
        buttonIn.setOnClickListener{
            val intent = Intent(this, RegustrationActivity::class.java)
            startActivity(intent)
        }
        val buttonRegist: Button = findViewById(R.id.button_registration)
        buttonRegist.setOnClickListener {
            val intent = Intent(this,activity_registrate::class.java)
            startActivity(intent)

        }

    }
}