package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.adapter.CommonItemAdapter
import ar.scacchipa.e_commerce.adapter.HighlightedItemAdapter
import ar.scacchipa.e_commerce.data.getFruitList
import ar.scacchipa.e_commerce.databinding.ScreenGondolaBinding
import ar.scacchipa.e_commerce.viewmodel.CommonItemsViewModel
import ar.scacchipa.e_commerce.viewmodel.HighlightedItemsViewModel

class GondolaFragment: Fragment() {

    private var binding: ScreenGondolaBinding? = null
    private val commonItemsVM: CommonItemsViewModel by viewModels()
    private val highlightedItemsVM: HighlightedItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        highlightedItemsVM.setHighlightedItems(getFruitList())
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenGondolaBinding.inflate(inflater, container, false)

        binding?.highItemRecyclerView?.layoutManager = LinearLayoutManager(
            container?.context, LinearLayoutManager.HORIZONTAL, false)
        binding?.highItemRecyclerView?.adapter = HighlightedItemAdapter(highlightedItemsVM.getHightedItems())

        binding?.commonItemrecyclerView?.layoutManager = LinearLayoutManager(
            container?.context, LinearLayoutManager.VERTICAL, false)
        binding?.commonItemrecyclerView?.adapter = CommonItemAdapter(commonItemsVM.getCommonItems())

//        binding?.cartImageView?.setOnClickListener { view ->
//            val action = NavGraphDirections
//                .actionGlobalCartFragment( null )
//            view.findNavController().navigate(action)
//        }

        return binding?.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        menu.findItem(R.id.action_back).isVisible = false
        menu.findItem(R.id.action_cart).isVisible = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_cart -> {
                val action: NavDirections = GondolaFragmentDirections
                    .actionGondolaFragmentToCartFragment(null)
                    this.findNavController().navigate(action)
            }
        }
        return true
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}