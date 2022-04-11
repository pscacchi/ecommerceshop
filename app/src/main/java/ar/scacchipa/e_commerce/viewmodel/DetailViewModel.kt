package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.Item

class DetailViewModel: ViewModel() {
    private val itemLD = MutableLiveData<Item>()

    fun setItem(item: Item) {
        itemLD.value = item
    }
    fun getItem(): Item? {
        return itemLD.value
    }

    fun toggleFavorite() {
        itemLD.value =
            itemLD.value?.favorite?.let {
                itemLD.value?.copy(
                    favorite = it.not()
                )
            }
    }
    fun addObserver(owner: LifecycleOwner, observer: Observer<Item>) {
        itemLD.observe(owner, observer)
    }
}
