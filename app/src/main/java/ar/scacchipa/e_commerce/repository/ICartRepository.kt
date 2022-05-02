package ar.scacchipa.e_commerce.repository

import ar.scacchipa.e_commerce.data.Item

interface ICartRepository {
    fun addOneItem(item: Item)
    fun removeOneItem(item: Item)
    fun getFruit(pos: Int): Item
    fun getCountOfAItem(item: Item): Int
    fun elementCount(): Int
}
