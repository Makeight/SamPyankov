package com.example.sampyankov

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

private var counter = 0
private var prefs: SharedPreferences? = null
lateinit var txt: TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        txt = findViewById(R.id.textView)
        prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        counter = prefs?.getInt("counter", 0)!!
        txt.text = counter.toString()
    }

    fun Plus(view: View) {
        counter++
        txt.text = counter.toString()
    }
    fun Minus(view: View) {
        counter--
        txt.text = counter.toString()
    }
    fun Save(view: View) {
        SaveDate(counter)
    }
    private fun SaveDate(result: Int){
        val editor = prefs?.edit()
        editor?.putInt("counter", result)
        editor?.apply()
    }
}