package ar.scacchipa.e_commerce.repository

import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.data.Item

class MockFruitItemRepository: IItemRepository {
    override fun getItemList(): List<Item> {
        return listOf(
            Item("Berenjena", 38.95, "Frutas ácidas", 1, false, false,
                R.raw.aubergine),
            Item("Limón", 25.40, "Frutas ácidas", 2, false, false,
                R.raw.lemon),
            Item("Manzana verde", 40.0, "Frutas ácidas", 3, true, false,
                R.raw.greenapple),
            Item("Naranja", 15.50, "Frutas ácidas", 4, false, false,
                R.raw.orange),
            Item("Piña", 59.95, "Frutas ácidas", 5, true, false,
                R.raw.pineapple),
            Item("Ciruela", 34.25, "Frutas dulces", 6, false, false,
                R.raw.plum),
            Item("Higo", 25.00, "Frutas dulces", 7, true, false,
                R.raw.fig),
            Item("Manzana Roja", 33.60, "Frutas dulces", 8, false, false,
                R.raw.redapple),
            Item("Melón", 19.90, "Frutas dulces", 9, false, false,
                R.raw.cantalaoupe),
            Item("Fresa", 45.50, "Frutas semiácidas", 10, false, false,
                R.raw.strawberry),
            Item("Lima", 30.00, "Frutas semiacidas", 11, false, false,
                R.raw.limette),
            Item("Mandarina", 22.50, "Frutas semiácidas", 12, true, false,
                R.raw.tangerine),
            Item("Tomate", 27.80, "Frutas semiácidas", 13, false, false,
                R.raw.tomato),
            Item("Almendras", 62.40, "Frutas neutras", 14, false, false,
                R.raw.almond),
            Item("Avellanas", 53.60, "Frutas neutras", 15, true, false,
                R.raw.hazelnuts),
            Item("Cacao", 46.60, "Frutas neutras",16, false, false,
                R.raw.cocoa
            ))
    }
}