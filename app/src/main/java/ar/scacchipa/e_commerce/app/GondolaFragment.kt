package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.scacchipa.e_commerce.NavGraphDirections
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
        commonItemsVM.setCommonItems(getFruitList())
        highlightedItemsVM.setHighlightedItems(getFruitList())
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

        binding?.cartImageView?.setOnClickListener { view ->
            val action = NavGraphDirections
                .actionGlobalCartFragment( null )
            view.findNavController().navigate(action)
        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}