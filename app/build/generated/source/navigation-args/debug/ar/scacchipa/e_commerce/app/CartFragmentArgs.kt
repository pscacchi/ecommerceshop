package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import ar.scacchipa.e_commerce.`data`.CartItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class CartFragmentArgs(
  public val submittedCard: CartItem?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(CartItem::class.java)) {
      result.putParcelable("submittedCard", this.submittedCard as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(CartItem::class.java)) {
      result.putSerializable("submittedCard", this.submittedCard as Serializable?)
    } else {
      throw UnsupportedOperationException(CartItem::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(CartItem::class.java)) {
      result.set("submittedCard", this.submittedCard as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(CartItem::class.java)) {
      result.set("submittedCard", this.submittedCard as Serializable?)
    } else {
      throw UnsupportedOperationException(CartItem::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CartFragmentArgs {
      bundle.setClassLoader(CartFragmentArgs::class.java.classLoader)
      val __submittedCard : CartItem?
      if (bundle.containsKey("submittedCard")) {
        if (Parcelable::class.java.isAssignableFrom(CartItem::class.java) ||
            Serializable::class.java.isAssignableFrom(CartItem::class.java)) {
          __submittedCard = bundle.get("submittedCard") as CartItem?
        } else {
          throw UnsupportedOperationException(CartItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"submittedCard\" is missing and does not have an android:defaultValue")
      }
      return CartFragmentArgs(__submittedCard)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CartFragmentArgs {
      val __submittedCard : CartItem?
      if (savedStateHandle.contains("submittedCard")) {
        if (Parcelable::class.java.isAssignableFrom(CartItem::class.java) ||
            Serializable::class.java.isAssignableFrom(CartItem::class.java)) {
          __submittedCard = savedStateHandle.get<CartItem?>("submittedCard")
        } else {
          throw UnsupportedOperationException(CartItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"submittedCard\" is missing and does not have an android:defaultValue")
      }
      return CartFragmentArgs(__submittedCard)
    }
  }
}
