package ar.scacchipa.e_commerce

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GondolaViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Fruit>>()

    fun setItems(items: List<Fruit>) {
        viewModel.value = items
    }

    fun getHighLightedItems(): List<Fruit> {
        return viewModel.value?.filter { fruit -> fruit.highlighted }?: listOf()
    }

    fun getCommonItems(): List<Fruit> {
        return viewModel.value?.filter { fruit -> fruit.highlighted.not() }?: listOf()
    }
}