package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import ar.scacchipa.e_commerce.databinding.ScreenDetailBinding

class DetailFragment: Fragment() {

    private var binding: ScreenDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenDetailBinding.inflate(inflater, container, false)

        Log.i("DETAIL", args.item.title)

        binding?.let { bind ->
            bind.title.text = args.item.title
            bind.ranking.text = "#${args.item.ranking}"
            bind.category.text = args.item.category
            bind.favorite.setImageResource(
                if (args.item.favorite) android.R.drawable.btn_star_big_on
                else android.R.drawable.btn_star_big_off
            )
            bind.detailItemImage.setImageResource(args.item.imageId)
            bind.addItemButton.text = "Add to cart | $" + "%.${2}f".format(args.item.price)
            bind.backDetailButton.setOnClickListener { view ->
                val action: NavDirections = DetailFragmentDirections
                    .actionDetailFragmentToGondolaFragment()
                view.findNavController().navigate(action)
            }
        }
        return binding?.root
    }

}