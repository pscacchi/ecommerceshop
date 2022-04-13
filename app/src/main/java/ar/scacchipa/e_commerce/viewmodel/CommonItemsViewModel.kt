package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item
import ar.scacchipa.e_commerce.data.getFruitList

class CommonItemsViewModel: ViewModel() {

    val fruitsList = getFruitList()

    private val listItemLD = MutableLiveData<List<Item>>()

    init {
        loadItems()
    }

    fun loadItems() {
        listItemLD.value = fruitsList
    }

    fun getCommonItems(): List<Item> {
        return listItemLD.value?.filter { fruit -> fruit.highlighted.not() } ?: listOf()
    }
}