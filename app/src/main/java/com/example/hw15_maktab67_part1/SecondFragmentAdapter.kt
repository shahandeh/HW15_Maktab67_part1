package com.example.hw15_maktab67_part1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SecondFragmentAdapter(private val listOfCity : MutableList<City>) : RecyclerView.Adapter<SecondFragmentAdapter.SecondFragmentViewHolder>() {

    class SecondFragmentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(city: City){
            textView.text = city.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondFragmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_name_sample, parent, false)
        return SecondFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondFragmentViewHolder, position: Int) {
        holder.bind(listOfCity[position])
    }

    override fun getItemCount(): Int {
        return listOfCity.size
    }

}