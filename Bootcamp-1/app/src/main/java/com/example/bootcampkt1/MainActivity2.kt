package com.example.bootcampkt1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView = findViewById(R.id.textView)

        //mainactivity'de gönderilen send key'i ile çekiyoruz.
        val get_data = intent.getStringExtra("send")

        //gelen veriyi alıp textView'e set ettik.
        textView.setText(get_data)
    }
}