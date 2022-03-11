package com.example.hw15_maktab67_part1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FirstFragmentAdapter(
    private val listOfCity: MutableList<City>,
    private val adapterClickListener: AdapterClickListener
) : RecyclerView.Adapter<FirstFragmentAdapter.FirstFragmentViewHolder>() {

    inner class FirstFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(city: City) {
            textView.text = city.name
            if (city.isSelected)
                textView.setBackgroundColor(Color.parseColor("#FF00FF"))
            else
                textView.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        override fun onClick(p0: View?) {
            adapterClickListener.click(
                bindingAdapterPosition,
                listOfCity[bindingAdapterPosition].isSelected
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstFragmentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.city_name_sample, parent, false)
        return FirstFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstFragmentViewHolder, position: Int) {
        holder.bind(listOfCity[position])
    }

    override fun getItemCount(): Int {
        return listOfCity.size
    }
}