package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.ScreenDetailBinding
import ar.scacchipa.e_commerce.viewmodel.DetailViewModel

class DetailFragment: Fragment() {

    private var binding: ScreenDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
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
                bind.ranking.text = getString(R.string.raking_placeholder, _item.ranking.toString())
                bind.category.text = _item.category
                refreshView()
                bind.favorite.setOnClickListener {
                    detailViewModel.toggleFavorite()
                }
                bind.detailItemImage.setImageResource(_item.imageId)
                bind.addItemButton.text = getString(R.string.add_item_button_placeholder,_item.price)
                bind.addItemButton.setOnClickListener { view ->
                    val action = DetailFragmentDirections
                        .actionDetailFragmentToCartFragment(CartItem(_item, 1))
                    view.findNavController().navigate(action)
                }
                bind.addItemButton
            }
        }
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding?.root
    }

    private fun refreshView() {
        binding?.favorite?.setImageResource(
            if (detailViewModel.getItem()?.favorite == true)
                android.R.drawable.btn_star_big_on
            else
                android.R.drawable.btn_star_big_off
        )
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        menu.findItem(R.id.action_back).isVisible = false
        menu.findItem(R.id.action_cart).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_back -> findNavController().navigateUp()
            android.R.id.home -> findNavController().navigateUp()
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}