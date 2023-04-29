package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FoodAddActivity : AppCompatActivity() {

    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_add)

        submitBtn = findViewById(R.id.submitBtn)




        submitBtn.setOnClickListener{
            val food = findViewById<EditText>(R.id.foodEt).text.toString()
            val calories = findViewById<EditText>(R.id.caloriesEt).text.toString().toInt()

            lifecycleScope.launch(Dispatchers.IO)  {
                (application as CaloriesApplication).db.caloriesDao().insert(
                    CaloriesEntity(food, calories)
                )
            }

            val i = Intent(this@FoodAddActivity, MainActivity::class.java)
            startActivity(i)
        }
    }
}