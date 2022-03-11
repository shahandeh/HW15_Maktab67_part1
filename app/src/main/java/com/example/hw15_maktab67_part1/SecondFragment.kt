package com.example.hw15_maktab67_part1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val appViewModel: AppViewModel by activityViewModels()

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view_second_fragment)
        appViewModel.listOfFavoriteLiveData.value?.also {
            recyclerView.adapter = SecondFragmentAdapter(it)
        }

        val swipeGesture = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.RIGHT) {
                    appViewModel.removeItem(viewHolder.bindingAdapterPosition)
                }
                recyclerView.adapter?.notifyItemRemoved(viewHolder.bindingAdapterPosition)
            }
        }
        ItemTouchHelper(swipeGesture).attachToRecyclerView(recyclerView)
    }
}