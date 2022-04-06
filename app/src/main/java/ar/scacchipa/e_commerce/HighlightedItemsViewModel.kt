package ar.scacchipa.e_commerce

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HighlightedItemsViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Fruit>>()

    fun setHighlightedItems(items: List<Fruit>) {
        viewModel.value = items
    }

    fun getHightedItems(): List<Fruit> {
        return viewModel.value?.filter { fruit -> fruit.highlighted }?: listOf()
    }
}