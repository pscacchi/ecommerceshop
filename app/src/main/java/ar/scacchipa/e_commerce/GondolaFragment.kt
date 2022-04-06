package ar.scacchipa.e_commerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ar.scacchipa.e_commerce.databinding.GondolaScreenBinding

class GondolaFragment: Fragment() {

    private var binding: GondolaScreenBinding? = null
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
        binding = GondolaScreenBinding.inflate(inflater, container, false)

        binding?.highItemRecyclerView?.layoutManager = LinearLayoutManager(
            container?.context, LinearLayoutManager.HORIZONTAL, false)
        binding?.highItemRecyclerView?.adapter = HighlightedItemAdapter(highlightedItemsVM.getHightedItems())


        return binding?.root
    }
}