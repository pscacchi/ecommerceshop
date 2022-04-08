package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item

class CommonItemsViewModel: ViewModel() {

    private val viewModel = MutableLiveData<List<Item>>()

    fun setCommonItems(items: List<Item>) {
        viewModel.value = items
    }

    fun getCommonItems(): List<Item> {
        return viewModel.value?.filter { fruit -> fruit.highlighted.not() }?: listOf()
    }
}