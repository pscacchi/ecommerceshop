package ar.scacchipa.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.app.DetailFragmentDirections
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.LayoutCardviewCartItemBinding

class CartCardAdapter (
    private val itemList: List<CartItem>
): RecyclerView.Adapter<CartCardAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = LayoutCardviewCartItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_cardview_cart_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val card = itemList[position]
        card.item?.let { _item ->
        holder.binding.cartItemTitle.text = _item.title
        holder.binding.cartItemPrice.text = "$" + "%.${2}f".format(_item.price)
        holder.binding.cartItemImageView.setImageResource(_item.imageId)
        holder.binding.ranking.text = "$" + "%.${2}f".format(_item.price)
        holder.binding.addOne.setOnClickListener { view ->
                val action = DetailFragmentDirections
                    .actionDetailFragmentToCartFragment(CartItem(_item, 1))
                view.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}