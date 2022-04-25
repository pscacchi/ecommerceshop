package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.`data`.CartItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class DetailFragmentDirections private constructor() {
  private data class ActionDetailFragmentToCartFragment(
    public val submittedCard: CartItem?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_detailFragment_to_cartFragment

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
    public fun actionDetailFragmentToGondolaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailFragment_to_gondolaFragment)

    public fun actionDetailFragmentToCartFragment(submittedCard: CartItem?): NavDirections =
        ActionDetailFragmentToCartFragment(submittedCard)
  }
}
