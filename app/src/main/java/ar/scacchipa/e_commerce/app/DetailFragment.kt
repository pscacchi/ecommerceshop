package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ar.scacchipa.e_commerce.databinding.ScreenDetailBinding

class DetailFragment: Fragment() {

    private var binding: ScreenDetailBinding? = null
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenDetailBinding.inflate(inflater, container, false)

        Log.i("DETAIL", args.item.title)

        return binding?.root
    }

}