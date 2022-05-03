package ar.scacchipa.e_commerce.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class Item(
    val title: String,
    val price: Double,
    val category: String,
    val ranking: Int,
    val highlighted: Boolean,
    val favorite: Boolean,
    val imageId: Int)
: Parcelable {

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        title = parcel.readString()?:"",
        price = parcel.readDouble(),
        category = parcel.readString()?:"",
        ranking = parcel.readInt(),
        highlighted = parcel.readBoolean(),
        favorite = parcel.readBoolean(),
        imageId = parcel.readInt())

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

    companion object CREATOR : Parcelable.Creator<Item> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}

