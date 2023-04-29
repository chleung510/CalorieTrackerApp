package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var foodRv: RecyclerView
   // private lateinit var binding: ActivityMainBinding
    private val caloriesItems = mutableListOf<Calories>()
    private lateinit var foodAddBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        foodRv = findViewById<RecyclerView>(R.id.foodRv)

        // Create adapter passing in the list of emails
        val caloriesAdapter = CaloriesAdapter(this, caloriesItems)

        // Set layout manager to position the items
        // tells the RecyclerView to layout the items on top of each other
        foodRv.layoutManager = LinearLayoutManager(this)
        // Attach the adapter to the RecyclerView to populate items
        foodRv.adapter = caloriesAdapter


        // Listen to any changes to items in the database
        // When we have a new list of items to display:
        // Map new items to DisplayArticles
        // Update our UI by passing the new list to our ArticleAdapter.
        lifecycleScope.launch {
            (application as CaloriesApplication).db.caloriesDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Calories(
                        entity.food,
                        entity.calories
                    )
                }.also { mappedList ->
                    caloriesItems.clear()
                    caloriesItems.addAll(mappedList)
                    caloriesAdapter.notifyDataSetChanged()
                }
            }
        }

        foodAddBtn = findViewById<Button>(R.id.foodAddBtn)

        foodAddBtn.setOnClickListener{
            val i = Intent(this@MainActivity, FoodAddActivity::class.java)
            startActivity(i)
        }
    }
}