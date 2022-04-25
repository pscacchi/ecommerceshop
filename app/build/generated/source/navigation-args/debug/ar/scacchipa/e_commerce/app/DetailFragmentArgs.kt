package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import ar.scacchipa.e_commerce.`data`.Item
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val item: Item
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.putParcelable("item", this.item as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.putSerializable("item", this.item as Serializable)
    } else {
      throw UnsupportedOperationException(Item::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Serializable)
    } else {
      throw UnsupportedOperationException(Item::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __item : Item?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = bundle.get("item") as Item?
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__item)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __item : Item?
      if (savedStateHandle.contains("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = savedStateHandle.get<Item?>("item")
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__item)
    }
  }
}
