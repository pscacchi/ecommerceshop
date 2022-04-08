package ar.scacchipa.e_commerce.data

import android.os.Parcel
import android.os.Parcelable

class CartItem : Parcelable {
    var item: Item?
    var itemCount: Int

    constructor(parcel: Parcel) {
        item = parcel.readParcelable(Item::class.java.classLoader)
        itemCount = parcel.readInt()
    }

    constructor(item: Item?, itemCount: Int) {
        this.item = item
        this.itemCount = itemCount
    }

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