package ar.scacchipa.e_commerce.app

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ar.scacchipa.e_commerce.R

public class CartFragmentDirections private constructor() {
  public companion object {
    public fun actionCartFragmentToGondolaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cartFragment_to_gondolaFragment)
  }
}
