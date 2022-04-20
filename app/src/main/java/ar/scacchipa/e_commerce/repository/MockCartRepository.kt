package ar.scacchipa.e_commerce.repository

import android.util.Log
import ar.scacchipa.e_commerce.data.Item

class MockCartRepository: ICartRepository {

    private val cartList = mutableListOf<Item>()

    override fun addOneItem(item: Item) {
        Log.i("ItemRepository", "AddOneItem $item")
    }

    override fun removeOneItem(item: Item) {
        Log.i("ItemRepository", "removeOneItem $item")
    }

    override fun getFruit(pos: Int): Item {
        Log.i("ItemRepository", "Return a Fruit")
        return cartList[4]
    }

    override fun getCountOfAItem(item: Item): Int {
        Log.i("ItemRepository", "Return a count")
        return 4
    }

    override fun elementCount(): Int {
        Log.i("ItemRepository", "Return a count")
        return cartList.size
    }
}