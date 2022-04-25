package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.`data`.CartItem
import ar.scacchipa.e_commerce.`data`.Item
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class GondolaFragmentDirections private constructor() {
  private data class ActionGondolaFragmentToDetailFragment(
    public val item: Item
  ) : NavDirections {
    public override val actionId: Int = R.id.action_gondolaFragment_to_detailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  private data class ActionGondolaFragmentToCartFragment(
    public val submittedCard: CartItem?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_gondolaFragment_to_cartFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionGondolaFragmentToDetailFragment(item: Item): NavDirections =
        ActionGondolaFragmentToDetailFragment(item)

    public fun actionGondolaFragmentToCartFragment(submittedCard: CartItem?): NavDirections =
        ActionGondolaFragmentToCartFragment(submittedCard)
  }
}
