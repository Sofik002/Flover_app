package com.example.floverapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegustrationActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autorization)

        val userLogin: EditText = findViewById(R.id.edit_mail)
        val userPassword: EditText = findViewById(R.id.edit_password)
        val logInButton: Button = findViewById(R.id.button)
        val linkTo: TextView = findViewById(R.id.link_to_regist)

        linkTo.setOnClickListener {
            val intent = Intent(this, activity_registrate::class.java)
            startActivity(intent)
        }
        logInButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else {
                val db = UserDatabase(this, null)
                val isExist = db.getUser(login, pass)
                if (isExist) {
                    val intent = Intent(this,MainPage::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Такого пользоватля нет", Toast.LENGTH_LONG).show()
            }

        }
    }
}



