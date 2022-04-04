package ar.scacchipa.e_commerce

class Fruit(
    val title: String,
    val price: Double,
    val category: String,
    val ranking: Int,
    val highlighted: Boolean,
    val favorite: Boolean
)

fun getFruitList(): List<Fruit> {
    return listOf<Fruit>(
        Fruit("Berenjena", 38.95, "Frutas ácidas", 1, false, false),
        Fruit("Limón", 25.40, "Frutas ácidas", 2, false, false),
        Fruit("Manzana verde", 40.0, "Frutas ácidas", 3, true, false),
        Fruit("Naranja", 15.50, "Frutas ácidas", 4, false, false),
        Fruit("Piña", 59.95, "Frutas ácidas", 5, true, false),
        Fruit("Ciruela", 34.25, "Frutas dulces", 6, false, false),
        Fruit("Higo", 25.00, "Frutas dulces", 7, true, false),
        Fruit("Manzana Roja", 33.60, "Frutas dulces", 8, false, false),
        Fruit("Melón", 19.90, "Frutas dulces", 9, false, false),
        Fruit("Fresa", 45.50, "Frutas semiácidas", 10, false, false),
        Fruit("Lima", 30.00, "Frutas semiacidas", 11, false, false),
        Fruit("Mandarina", 22.50, "Frutas semiácidas", 12, true, false),
        Fruit("Tomate", 27.80, "Frutas semiácidas", 13, false, false),
        Fruit("Almendras", 62.40, "Frutas neutras", 14, false, false),
        Fruit("Avellanas", 53.60, "Frutas neutras", 15, true, false),
        Fruit("Cacao", 46.60, "Frutas neutras",16, false, false)
    )
}