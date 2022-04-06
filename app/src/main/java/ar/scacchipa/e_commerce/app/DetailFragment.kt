package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.scacchipa.e_commerce.databinding.DetailScreenBinding

class DetailFragment: Fragment() {

    private var binding: DetailScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }
}