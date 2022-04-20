package ar.scacchipa.e_commerce.app

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.adapter.CartCardAdapter
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.ScreenCartBinding
import ar.scacchipa.e_commerce.viewmodel.ItemCartViewModel

class CartFragment: Fragment() {

    private val itemCartItemVM: ItemCartViewModel by activityViewModels()
    private val args: CartFragmentArgs by navArgs()
    private var binding: ScreenCartBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
            (binding?.cartRecyclerView?.adapter as CartCardAdapter)
                .updateCardList(itemCartItemVM.getCardList())
            binding?.cartTotal?.text = calcTotalPrice()
        }
        binding?.let { _binding ->
            //TODO: The calcTotalPrice() must be performed into the VM is a business logic
            _binding.cartTotal.text = calcTotalPrice()
            _binding.cartRecyclerView.layoutManager = LinearLayoutManager(container?.context)
            //TODO: Avoid recreate adapter each time that you update the list, avoid "screen flashes"
            _binding.cartRecyclerView.adapter = CartCardAdapter(
                itemCartItemVM.getCardList(),
                itemCartItemVM)

            _binding.paymentButton.setOnClickListener { view ->
                val itemList = itemCartItemVM.getCardList()
                if (itemList.isNotEmpty()) {
                    val countText =
                        when (itemCartItemVM.getCardList().sumOf { item -> item.itemCount }) {
                            1 -> getString(R.string.one_item_text)
                            2 -> getString(R.string.two_items_text)
                            3 -> getString(R.string.three_items_text)
                            else -> getString(R.string.more_than_three_items_text)
                        }
                    Toast.makeText(view.context, getString(R.string.toast_message,countText), Toast.LENGTH_SHORT)
                        .show()
                }
                itemCartItemVM.clear()
            }
        }
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding?.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        menu.findItem(R.id.action_back).isVisible = false
        menu.findItem(R.id.action_cart).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_back -> {
                findNavController().navigateUp()
            }
            android.R.id.home -> {
                val action: NavDirections = CartFragmentDirections
                    .actionCartFragmentToGondolaFragment()
                findNavController().navigate(action)
            }
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun calcTotalPrice(): String {
        val totalPrice = itemCartItemVM.getCardList().fold(0.0) { acc: Double, cartItem: CartItem ->
            acc + (cartItem.item?.price ?: 0.0) * cartItem.itemCount
        }
        return this.context?.getString(R.string.price_placeholder, totalPrice)?:""
    }
}