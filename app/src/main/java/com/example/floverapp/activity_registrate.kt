package com.example.floverapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_registrate : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrate)

        val userLogin: EditText = findViewById(R.id.edit_login)
        val userEmail: EditText = findViewById(R.id.edit_mail)
        val userPass: EditText = findViewById(R.id.edit_password)
        val button: Button = findViewById(R.id.button)
        val linkTo: TextView = findViewById(R.id.link_to_login)

        linkTo.setOnClickListener {
            val intent = Intent(this, RegustrationActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == "")
                Toast.makeText(this,"Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else{
                val user = User(login, email, pass)
                val db = UserDatabase(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $login добавлен",Toast.LENGTH_LONG ).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}