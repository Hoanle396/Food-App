package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Fooddetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fooddetails)
        var name= intent.extras?.getString("name")
        var des= intent.extras?.getString("des")
        var image= intent.extras?.getInt("image")

        var img:ImageView=findViewById(R.id.imageView2)
        var names:TextView=findViewById(R.id.textView2)
        var descrip:TextView=findViewById(R.id.textView3)
        img.setImageResource(image!!)
        names.text=name
        descrip.text=des
    }
}