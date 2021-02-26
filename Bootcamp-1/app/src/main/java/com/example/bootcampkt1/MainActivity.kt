package com.example.bootcampkt1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    //private fonksiyonların içinde değişkenleri kullanabilmek için global değişken olarak tanımlamalıyız
    //ve global değişkenlere başlangıç değeri atanmak zorundadır
    //var textView : TextView ? = null
    //global değişkene başlangıç değeri atamak zorunda kalmadan tanımlamak istersek
    //"lateinit" kullanmamız gerekir.
    //lateinit var textView : TextView //var yaptığımız için her yerde kullanabiliriz artık
    //lateinit var button: Button

    lateinit var diceText : TextView
    lateinit var diceButton: Button
    lateinit var diceImage : ImageView
    lateinit var sendButton : Button
    lateinit var sendText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView ve button tanımlamasını bir kere yapacağımız için val kullanıyoruz
        //tanımlama yapmak için "val textView : TextView" bu syntax ile atama yapabiliyoruz.
        //val textView : TextView = findViewById(R.id.tvWrite)
        //R'nin buradaki anlamı res'in altında oldğunu belirtmek için, yani res'in altındaki activitymainden ilgili id'yi almamızı sağlıyor
        //val button : Button = findViewById(R.id.btnChange)
        //val randomNumber = (1..10).random()

        diceText = findViewById(R.id.tvDice)
        diceButton = findViewById(R.id.btnDice)
        diceImage = findViewById(R.id.ivDice)
        sendText = findViewById(R.id.etSend)
        sendButton = findViewById(R.id.btnSend)

        //butona tıkladığımız anda:
        diceButton.setOnClickListener {

            //integer değer alındığı için bunu stringe dönüştürmeliyiz
            //bu işlemi yapabilmek için de toString() kullanılmalı
            //textView.text = randomNumber.toString()
            //yukarıda string ifade alıp burada sayı olarak yazdırmak isteseydin
            //toInt() kullanırdık

            changeNumber()
            //özel fonksiyonumuzu burada tanımladık ve butona her basıldığında fonksiyonumuza gidip
            //orada tanımlanan görevi yerine getiriyor.

        }

        sendButton.setOnClickListener{

            send_Text()
        }

    }

        //özel fonksiyon oluşturuyoruz:
        private fun changeNumber(){
            val randomNumber = (1..6).random()
            //eklenen image'lerin kaynağını alabilmek için:
            val drawableResource = when(randomNumber){
                //randomnumber 1 olduğu zaman R.drawable
                //R.drawable => res'in altında drawable'ın içinde olduğunu belirtmek için
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }

            //diceImage'ı yukarıdaki if else yapısına göre set et.
            diceImage.setImageResource(drawableResource)

            diceText.text = randomNumber.toString()


            //ToastMessage:
            //this = hangi activity'de çalışacağımızı belirtir, bu activiyde çalışacak
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()

        }

        private fun send_Text(){
            //bu sayfadan mainactivity2'ye veri gönderme izni
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("send", sendText.text.toString())
            startActivity(intent)

        }


        /*println("OnCreate Called")*/

    /*
    //override üst sınıflarla etkileşim halinde olmamız durumunda kullanmamız gereken method
    override fun onStart() {
        super.onStart()
        println("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy Called")
    }

     */
}