package com.example.hw15_maktab67_part1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    private var list = mutableListOf(
        City("A", false),
        City("B", false),
        City("C", false),
        City("D", false),
        City("E", false),
        City("F", false),
        City("G", false),
        City("H", false),
        City("I", false),
        City("J", false),
        City("K", false),
        City("L", false),
        City("M", false),
        City("N", false),
        City("O", false),
        City("P", false),
        City("Q", false),
        City("R", false),
        City("S", false),
        City("T", false),
        City("U", false),
        City("V", false),
        City("W", false),
        City("X", false),
        City("Y", false),
        City("Z", false)
    )

    private val listOfFavorite = mutableListOf<City>()

    var listOfFavoriteLiveData = MutableLiveData<MutableList<City>>(mutableListOf())

    val listOfCityLiveData = MutableLiveData(list)

    fun select(position: Int, isSelected: Boolean) {

        if (isSelected) {
            listOfFavorite.remove(list[position])
            listOfFavoriteLiveData.value = listOfFavorite
        } else {
            listOfFavorite.add(list[position])
            listOfFavoriteLiveData.value = listOfFavorite
        }

        list[position].isSelected = list[position].isSelected.not()
        listOfCityLiveData.value?.get(position)?.isSelected = list[position].isSelected
    }

    fun removeItem(position: Int) {
        listOfFavorite.removeAt(position)
        listOfFavoriteLiveData.value = listOfFavorite

        list[position].isSelected = list[position].isSelected.not()
        listOfCityLiveData.value = list
    }

}