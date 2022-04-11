package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.data.Item

class ItemCartViewModel: ViewModel() {

    private val cards = MutableLiveData(listOf<CartItem>())

    fun getCardList(): List<CartItem> {
        return cards.value?: listOf()
    }

    fun addCard(item: Item?, count: Int) {
        if (item != null) {
            cards.value?.let { _cards ->
                val mutableList = _cards.toMutableList()
                val card = mutableList.find { card -> card.item?.title == item.title }
                if (card != null) {
                    card.itemCount += count
                } else {
                    mutableList.add(CartItem(item, 1))
                }
                cards.value = mutableList
            }
        }
    }
    fun clear() {
        cards.value = listOf()
    }
    fun addObserver(owner: LifecycleOwner, observer: Observer<List<CartItem>>) {
        cards.observe(owner, observer)
    }

}