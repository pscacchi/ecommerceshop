package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.ScreenDetailBinding
import ar.scacchipa.e_commerce.viewmodel.DetailViewModel

class DetailFragment: Fragment() {

    private var binding: ScreenDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenDetailBinding.inflate(inflater, container, false)
        detailViewModel.setItem(args.item)

        detailViewModel.addObserver(this) { refreshView() }

        detailViewModel.getItem()?.let { _item ->
            binding?.let { bind ->
                bind.title.text = _item.title
                bind.ranking.text = "#${_item.ranking}"
                bind.category.text = _item.category
                refreshView()
                bind.favorite.setOnClickListener {
                    detailViewModel.toggleFavorite()
                }
                bind.detailItemImage.setImageResource(_item.imageId)
                bind.addItemButton.text = "Add to cart | $" + "%.${2}f".format(_item.price)
                bind.addItemButton.setOnClickListener { view ->
                    val action = DetailFragmentDirections
                        .actionDetailFragmentToCartFragment(CartItem(_item, 1))
                    view.findNavController().navigate(action)
                }
                bind.backDetailButton.setOnClickListener { view ->
                    val action = DetailFragmentDirections
                        .actionDetailFragmentToGondolaFragment()
                    view.findNavController().navigate(action)
                }
            }
        }
        return binding?.root
    }
    fun refreshView() {
        binding?.favorite?.setImageResource(
            if (detailViewModel.getItem()?.favorite == true)
                android.R.drawable.btn_star_big_on
            else
                android.R.drawable.btn_star_big_off
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}