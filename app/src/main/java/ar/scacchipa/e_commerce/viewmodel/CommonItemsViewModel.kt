package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item
import ar.scacchipa.e_commerce.repository.IItemRepository
import ar.scacchipa.e_commerce.repository.MockFruitItemRepository

class CommonItemsViewModel: ViewModel() {

    private val itemRepository: IItemRepository = MockFruitItemRepository()

    private val listItemLD = MutableLiveData<List<Item>>()

    init {
        loadItems()
    }

    private fun loadItems() {
        listItemLD.value = itemRepository.getItemList()
    }

    fun getCommonItems(): List<Item> {
        return listItemLD.value?.filter { fruit -> fruit.highlighted.not() } ?: listOf()
    }
}