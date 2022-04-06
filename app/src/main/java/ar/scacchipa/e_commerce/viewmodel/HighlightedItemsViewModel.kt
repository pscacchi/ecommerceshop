package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.Fruit


class HighlightedItemsViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Fruit>>()

    fun setHighlightedItems(items: List<Fruit>) {
        viewModel.value = items
    }

    fun getHightedItems(): List<Fruit> {
        return viewModel.value?.filter { fruit -> fruit.highlighted }?: listOf()
    }
}