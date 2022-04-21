package ar.scacchipa.e_commerce.repository

import ar.scacchipa.e_commerce.data.Item

interface IItemRepository {
    fun getItemList(): List<Item>
}