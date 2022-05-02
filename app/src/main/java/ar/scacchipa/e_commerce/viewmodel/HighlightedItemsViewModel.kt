package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item

class HighlightedItemsViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Item>>()

    fun setHighlightedItems(items: List<Item>) {
        viewModel.value = items
    }

    fun getHighlightedItems(): List<Item> {
        return viewModel.value?.filter { fruit -> fruit.highlighted }?: listOf()
    }
}