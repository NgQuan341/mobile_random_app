package com.example.midterm2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.midterm2.adapters.FoodAdapters
import com.example.midterm2.model.FoodItem
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var arrayList:ArrayList<FoodItem>? = null
    private var gridView:GridView ? = null
    private var foodAdapters:FoodAdapters ? = null
    private var myButton:Button ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.my_grid_view_list)
        myButton = findViewById(R.id.my_button)
        arrayList = ArrayList()
        arrayList = setDataList()
        this.randomFoodItem(myButton!!)
        foodAdapters = FoodAdapters(applicationContext, arrayList!!)
        gridView?.adapter = foodAdapters
        gridView?.onItemClickListener = this
    }
    private fun setDataList(): ArrayList<FoodItem>{
        val arrayList:ArrayList<FoodItem> = ArrayList()
        arrayList.add(FoodItem(R.drawable.chaos, "Coffee"))
        arrayList.add(FoodItem(R.drawable.fruit_salad, "Fruit salad"))
        arrayList.add(FoodItem(R.drawable.green_noddle, "Green noddle"))
        arrayList.add(FoodItem(R.drawable.herbal_pancake, "Herbal pancake"))
        arrayList.add(FoodItem(R.drawable.icream, "Ice-cream"))
        arrayList.add(FoodItem(R.drawable.spacy_fresh_crab, "Spacy fresh crab"))
        arrayList.add(FoodItem(R.drawable.nems, "Chocolate"))
        arrayList.add(FoodItem(R.drawable.meat, "Meat"))
        arrayList.add(FoodItem(R.drawable.pizza, "Pizza"))
        arrayList.add(FoodItem(R.drawable.chaos, "Coffee"))
        arrayList.add(FoodItem(R.drawable.fruit_salad, "Fruit salad"))
        arrayList.add(FoodItem(R.drawable.green_noddle, "Green noddle"))
        arrayList.add(FoodItem(R.drawable.herbal_pancake, "Herbal pancake"))
        arrayList.add(FoodItem(R.drawable.icream, "Ice-cream"))
        arrayList.add(FoodItem(R.drawable.spacy_fresh_crab, "Spacy fresh crab"))
        arrayList.add(FoodItem(R.drawable.nems, "Chocolate"))
        arrayList.add(FoodItem(R.drawable.meat, "Meat"))
        arrayList.add(FoodItem(R.drawable.pizza, "Pizza"))

        return arrayList

    }
    private fun randomFoodItem(myButton: Button){
        myButton!!.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.dialog_item_random, null)
            val imageView: ImageView = view.findViewById(R.id.img)
            val textView: TextView = view.findViewById(R.id.name)
            val rand = arrayList?.shuffled()?.first()
            if (rand != null) {
                textView.text = rand.name
                val icons: Int = rand.icons as Int
                imageView.setImageResource(icons)
            }
            val dialog = Dialog(this)
            dialog.setContentView(view)
            dialog.show()
        }
    }
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val items:FoodItem = arrayList!!.get(position)
        Toast.makeText(applicationContext, items.name, Toast.LENGTH_LONG).show()
    }
}