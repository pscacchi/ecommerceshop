package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.scacchipa.e_commerce.databinding.ScreenCartBinding

class CartFragment: Fragment() {

    private var binding: ScreenCartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenCartBinding.inflate(inflater, container, false)
        return binding?.root
    }
}