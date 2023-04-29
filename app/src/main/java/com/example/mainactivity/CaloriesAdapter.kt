package com.example.mainactivity

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Here our EmailAdapter extends RecyclerView Adapter as an abstraction class
// Then allows the constructor to take in a list of Calories and storing it as a variable
class CaloriesAdapter(private val context: Context, private val caloriesItems: List<Calories>):RecyclerView.Adapter<CaloriesAdapter.Viewholder>() {

    // To get references of views for each item on the list
    // Used to cache the views within the item layout for fast access
    // "ViewHolder" object which describes and provides access to all the views within each item row.
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // subviews within an item(or row)
        val foodTv: TextView
        val calorieTv: TextView


        // Act as a constructor to accept each row(or item) and look for subviews
        init{
            foodTv = itemView.findViewById<TextView>(R.id.foodTv)
            calorieTv = itemView.findViewById<TextView>(R.id.calorieTv)
        }
    }


    // Below is called when RecyclerView needs a new ViewHolder of the given type to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val context = parent.context // get reference of the xml file
        val inflater = LayoutInflater.from(context)

        // LayoutInflater takes an XML file as input and builds the View objects from it.
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_food, parent, false)
        // Return a new holder instance
        return Viewholder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        // Get the data model based on position
        val caloriesItem = caloriesItems.get(position)

        // Set item views based on views and data model
        holder.foodTv.text = caloriesItem.food
        holder.calorieTv.text = caloriesItem.calories.toString()
    }



    override fun getItemCount(): Int {
        return caloriesItems.size
    }
}


