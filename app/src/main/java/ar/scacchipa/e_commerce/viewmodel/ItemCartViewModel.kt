package ar.scacchipa.e_commerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.data.Item

class ItemCartViewModel: ViewModel() {

    private val cards = MutableLiveData(listOf<CartItem>())

    fun getCardList(): List<CartItem> {
        return cards.value?: listOf()
    }

    fun addCard(item: Item?, count: Int) {
        cards.value?.let { _cards ->
            val mutableList = _cards.toMutableList()
            val card = mutableList.find { card -> card.item == item }
            if (card != null) {
                card.itemCount += count
            } else {
                mutableList.add(CartItem(item, 1))
            }
            cards.value = mutableList
        }
    }

    fun removeOneItem(pos: Int) {
        cards.value?.let { _cards ->
            val mutableList = _cards.toMutableList()
            if (mutableList[pos].itemCount >= 1) {
                mutableList[pos].itemCount--
            } else {
                mutableList.removeAt(pos)
            }
            cards.postValue(mutableList)
        }
    }
}