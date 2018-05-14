package com.example.jorgecarrillo.ejemploandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_actividad3.*

class Actividad3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad3)
        button3.setOnClickListener{v: View? -> IrActividad2()  }
    }
    fun IrActividad2(){
        val intent = Intent(this, Actividad2::class.java)
        startActivity(intent)
    }
}
