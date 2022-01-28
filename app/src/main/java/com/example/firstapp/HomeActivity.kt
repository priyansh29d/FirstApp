package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity(), View.OnFocusChangeListener {
    lateinit var tvHome:TextView
    lateinit var etContact: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //var name = intent.extras?.getString("sk")
        tvHome = findViewById(R.id.tvHome) //initializing
        //  tvHome.text = name

        etContact = findViewById(R.id.etContact)

        etContact.setOnFocusChangeListener(this)

    }
    fun handleClick(view: android.view.View) {
        when(view.id){
            R.id.btnSend -> {  startDialer() }
            R.id.btnMain -> {startMain() }
        }
    }

    private fun startDialer() {
        var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:21345678")) //implicit intent
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

    override fun onFocusChange(p0: View?, isFocussed: Boolean) {
        if(isFocussed){
            Toast.makeText(this,"focussed",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show()

        }
    }
}