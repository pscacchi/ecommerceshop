package ar.scacchipa.e_commerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.scacchipa.e_commerce.databinding.CartScreenBinding

class CartFragment: Fragment() {

    private var binding: CartScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CartScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }
}