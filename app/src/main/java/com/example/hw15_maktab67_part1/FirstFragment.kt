package com.example.hw15_maktab67_part1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment(R.layout.fragment_first), AdapterClickListener {

    private val appViewModel: AppViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view_first_fragment)

        view.findViewById<Button>(R.id.next_button).setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, SecondFragment())
                .addToBackStack("main").setReorderingAllowed(true).commit()
        }

        appViewModel.listOfCityLiveData.value?.also {
            recyclerView.adapter = FirstFragmentAdapter(it, this)
        }
    }

    override fun click(position: Int, isSelected: Boolean) {
        appViewModel.select(position, isSelected)
        recyclerView.adapter?.notifyItemChanged(position)
    }
}