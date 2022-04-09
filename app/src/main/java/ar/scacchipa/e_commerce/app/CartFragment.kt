package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            args.submittedCard.item,
            args.submittedCard.itemCount)
        binding?.let { _binding ->
            _binding.cartTotal.text =
                itemCartItemVM.getCardList().fold(0.0) { acc: Double, cartItem: CartItem ->
                    acc + (cartItem.item?.price ?: 0.0) * cartItem.itemCount
                }.toString()
            _binding.cartRecyclerView.layoutManager = LinearLayoutManager(container?.context)
            Log.i("CartFragment", "X->" + itemCartItemVM.getCardList().size.toString())
            _binding.cartRecyclerView.adapter = CartCardAdapter(itemCartItemVM.getCardList())
            _binding.backCartButton.setOnClickListener { view ->
                val action = CartFragmentDirections.actionCartFragmentToGondolaFragment()
                view.findNavController().navigate(action)
            }
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}