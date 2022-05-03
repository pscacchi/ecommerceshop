package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item

class CommonItemsViewModel: ViewModel() {

    private val listItemLD = MutableLiveData<List<Item>>()

    fun setCommonItems(itemList: List<Item>) {
        listItemLD.value = itemList
    }

    fun getCommonItems(): List<Item> {
        return listItemLD.value?.filter { fruit -> fruit.highlighted.not() } ?: listOf()
    }
}