package com.example.sampyankov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern
import kotlin.io.path.Path

class MainActivity : AppCompatActivity() {
    lateinit var mail: EditText
    lateinit var pass: EditText
    val pattern = ("[a-z]{1-100}" + "@" + "[a-z]{1,6}" + "." + "[a-z]{1,5}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mail = findViewById(R.id.textView)
        pass = findViewById(R.id.textView2)
    }

    private fun emailValid(text:String): Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun next(view: View) {
    if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
    {
        if (emailValid(mail.text.toString()))
        {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this, "Неверно введёт email", Toast.LENGTH_SHORT).show()
        }
    }
    else
    {
       Toast.makeText(this, "Заполните все текстовые поля", Toast.LENGTH_LONG).show()
    }

    }
}