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
                val mutableCopyList = _cards.map { it.copy() }.toMutableList()
                val card = mutableCopyList.find { card -> card.item?.title == item.title }
                if (card != null) {
                    card.itemCount += count
                    if (card.itemCount <= 0) {
                        mutableCopyList.remove(card)
                    }
                } else {
                    mutableCopyList.add(CartItem(item, 1))
                }
                cards.value = mutableCopyList
            }
        }
    }
    fun clear() {
        cards.value = listOf()
    }
    fun addObserver(owner: LifecycleOwner, observer: Observer<List<CartItem>>) {
        cards.observe(owner, observer)
    }

    fun calcTotalPrice(): Double {
        return getCardList().fold(0.0) { acc: Double, cartItem: CartItem ->
            acc + (cartItem.item?.price ?: 0.0) * cartItem.itemCount
        }
    }
    fun getProductCount(): Int {
        return cards.value?.fold(0) {acc: Int, cartItem: CartItem ->
            acc +  cartItem.itemCount
        }?:0
    }
}