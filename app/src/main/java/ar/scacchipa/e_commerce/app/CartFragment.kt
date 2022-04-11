package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ar.scacchipa.e_commerce.adapter.CartCardAdapter
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.ScreenCartBinding
import ar.scacchipa.e_commerce.viewmodel.ItemCartViewModel

class CartFragment: Fragment() {

    private val itemCartItemVM: ItemCartViewModel by activityViewModels()
    private val args: CartFragmentArgs by navArgs()
    private var binding: ScreenCartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenCartBinding.inflate(inflater, container, false)
        itemCartItemVM.addCard(
            args.submittedCard?.item,
            args.submittedCard?.itemCount?:0)
        itemCartItemVM.addObserver(this) {
            binding?.cartRecyclerView?.adapter = CartCardAdapter(itemCartItemVM.getCardList())
        }
        binding?.let { _binding ->
            _binding.cartTotal.text = "$%.${2}f".format(
                itemCartItemVM.getCardList().fold(0.0) { acc: Double, cartItem: CartItem ->
                    acc + (cartItem.item?.price ?: 0.0) * cartItem.itemCount
                })
            _binding.cartRecyclerView.layoutManager = LinearLayoutManager(container?.context)
            _binding.cartRecyclerView.adapter = CartCardAdapter(itemCartItemVM.getCardList())
            _binding.backCartButton.setOnClickListener { view ->
                val action = CartFragmentDirections.actionCartFragmentToGondolaFragment()
                view.findNavController().navigate(action)
            }
            _binding.paymentButton.setOnClickListener { view ->
                val itemList = itemCartItemVM.getCardList()
                if (itemList.isNotEmpty()) {
                    val countText =
                        when (itemCartItemVM.getCardList().sumOf { item -> item.itemCount }) {
                            1 -> "a item"
                            2 -> "two items"
                            3 -> "three items"
                            else -> "a lot of things"
                        }
                    Toast.makeText(view.context, "You have bought $countText", Toast.LENGTH_SHORT)
                        .show()
                }
                itemCartItemVM.clear()
            }
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}