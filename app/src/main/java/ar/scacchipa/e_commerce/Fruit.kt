package ar.scacchipa.e_commerce

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class Fruit : Parcelable {

    val title: String
    val price: Double
    val category: String
    val ranking: Int
    val highlighted: Boolean
    val favorite: Boolean
    val imageId: Int

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) {
        title = parcel.readString()?:""
        price = parcel.readDouble()
        category = parcel.readString()?:""
        ranking = parcel.readInt()
        highlighted = parcel.readBoolean()
        favorite = parcel.readBoolean()
        imageId = parcel.readInt()
    }

    constructor(
        title: String,
        price: Double,
        category: String,
        ranking: Int,
        highlighted: Boolean,
        favorite: Boolean,
        imageId: Int
    ) {
        this.title = title
        this.price = price
        this.category = category
        this.ranking = ranking
        this.highlighted = highlighted
        this.favorite = favorite
        this.imageId = imageId
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeString(category)
        parcel.writeInt(ranking)
        parcel.writeBoolean(highlighted)
        parcel.writeBoolean(favorite)
        parcel.writeInt(imageId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruit> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }
}


fun getFruitList(): List<Fruit> {
    return listOf<Fruit>(
        Fruit("Berenjena", 38.95, "Frutas ácidas", 1, false, false,
        R.raw.aubergine),
        Fruit("Limón", 25.40, "Frutas ácidas", 2, false, false,
        R.raw.lemon),
        Fruit("Manzana verde", 40.0, "Frutas ácidas", 3, true, false,
        R.raw.greenapple),
        Fruit("Naranja", 15.50, "Frutas ácidas", 4, false, false,
        R.raw.orange),
        Fruit("Piña", 59.95, "Frutas ácidas", 5, true, false,
        R.raw.pineapple),
        Fruit("Ciruela", 34.25, "Frutas dulces", 6, false, false,
        R.raw.plum),
        Fruit("Higo", 25.00, "Frutas dulces", 7, true, false,
        R.raw.fig),
        Fruit("Manzana Roja", 33.60, "Frutas dulces", 8, false, false,
        R.raw.redapple),
        Fruit("Melón", 19.90, "Frutas dulces", 9, false, false,
        R.raw.cantalaoupe),
        Fruit("Fresa", 45.50, "Frutas semiácidas", 10, false, false,
        R.raw.strawberry),
        Fruit("Lima", 30.00, "Frutas semiacidas", 11, false, false,
        R.raw.limette),
        Fruit("Mandarina", 22.50, "Frutas semiácidas", 12, true, false,
        R.raw.tangerine),
        Fruit("Tomate", 27.80, "Frutas semiácidas", 13, false, false,
        R.raw.tomato),
        Fruit("Almendras", 62.40, "Frutas neutras", 14, false, false,
        R.raw.almond),
        Fruit("Avellanas", 53.60, "Frutas neutras", 15, true, false,
        R.raw.hazelnuts),
        Fruit("Cacao", 46.60, "Frutas neutras",16, false, false,
            R.raw.cocoa
        )
    )
}