package ar.scacchipa.e_commerce.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.NavGraphDirections
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.LayoutCardviewCartItemBinding

class CartCardAdapter (
    private val itemList: List<CartItem>
): RecyclerView.Adapter<CartCardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutCardviewCartItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutCardviewCartItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("Cart position", position.toString())
        val card = itemList[position]
        card.item?.let { _item ->
            holder.binding.cartItemTitle.text = _item.title
            holder.binding.cartItemPrice.text = "$" + "%.${2}f".format(_item.price)
            holder.binding.cartItemImageView.setImageResource(_item.imageId)
            holder.binding.elementCount.text = card.itemCount.toString()
            holder.binding.ranking.text = "$" + "%.${2}f".format(_item.price)
            holder.binding.addOne.setOnClickListener { view ->
                val action = NavGraphDirections
                    .actionGlobalCartFragment(CartItem(_item, 1))
                view.findNavController().navigate(action)
            }
            holder.binding.removeOne.setOnClickListener { view ->
                val action = NavGraphDirections
                    .actionGlobalCartFragment(CartItem(_item, -1))
                view.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}