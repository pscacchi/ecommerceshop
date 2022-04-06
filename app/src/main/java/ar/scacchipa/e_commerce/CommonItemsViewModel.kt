package ar.scacchipa.e_commerce

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonItemsViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Fruit>>()

    fun setCommonItems(items: List<Fruit>) {
        viewModel.value = items
    }

    fun getCommonItems(): List<Fruit> {
        return viewModel.value?.filter { fruit -> fruit.highlighted.not() }?: listOf()
    }
}