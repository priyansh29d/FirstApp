package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    lateinit var tvHome:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var name = intent.extras?.getString("AV")
        tvHome = findViewById(R.id.tvHome)
        tvHome.text = name

    }
    fun handleClick(view: android.view.View) {
        when(view.id){
            R.id.btnSend -> {  startDialer() }
            R.id.btnMain -> {startMain() }
        }
    }

    private fun startDialer() {
        var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:21345678"))
        startActivity(dialIntent)
    }

    private fun startMain() {
        var intent: Intent
        intent = Intent(this, MainActivity::class.java)
        intent.putExtra("PJ", "Priyansh Jain")
        startActivityForResult(intent,123)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == 123){
            tvHome.text = data?.extras?.getString("con")
        }
    }
}