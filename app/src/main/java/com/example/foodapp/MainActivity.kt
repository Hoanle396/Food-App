package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var list=ArrayList<Food>()
    var adapter:FoodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(Food("Gà","Con Gà ngu ngốc bị thịt",R.drawable.chicken))
        list.add(Food("Cocacola","Cocacola ngon từ nước ngọt từ chai",R.drawable.cocacola))
        list.add(Food("Coffe","Coffe giải tỏa căng thẳng",R.drawable.coffe))
        list.add(Food("Nước Ngọt","Nước gì lạ quá ta",R.drawable.food))
        list.add(Food("Bánh","Bánh thiệt ngon",R.drawable.hamboger))
        list.add(Food("pepsi","Pepsi chai nước khá giống cocacola nhưng lại rất khác",R.drawable.pepsi))
       adapter=FoodAdapter(this,list)
        val girdView=findViewById(R.id.GirdView) as GridView
        girdView.adapter=adapter
    }

    inner  class  FoodAdapter:BaseAdapter{
        var list=ArrayList<Food>()
        var context:Context?=null
        constructor(context: Context,list: ArrayList<Food>){
            this.context=context
            this.list=list
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun getItem(p0: Int): Any {
           return list[p0]
        }

        override fun getItemId(p0: Int): Long {
          return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food=list[p0]
           var inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflater.inflate(R.layout.food_item,null)
            var image:ImageView=view.findViewById(R.id.imageView)
            var text:TextView=view.findViewById(R.id.textView)
            image.setImageResource(food.image!!)
            text.text=food.name
            view.setOnClickListener {
                var intent=Intent(context,Fooddetails::class.java)
                intent.putExtra("image",food.image!!)
                intent.putExtra("name",food.name)
                intent.putExtra("des",food.des)
                context!!.startActivity(intent)
            }
            return view
        }
    }
}