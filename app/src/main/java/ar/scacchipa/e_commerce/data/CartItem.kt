package ar.scacchipa.e_commerce.data

import android.os.Parcel
import android.os.Parcelable

data class CartItem(
    var item: Item?,
    var itemCount: Int)
    : Parcelable {

    constructor(parcel: Parcel): this(
        item = parcel.readParcelable(Item::class.java.classLoader),
        itemCount = parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(item, 0)
        parcel.writeInt(itemCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartItem> {
        override fun createFromParcel(parcel: Parcel): CartItem {
            return CartItem(parcel)
        }

        override fun newArray(size: Int): Array<CartItem?> {
            return arrayOfNulls(size)
        }
    }

}