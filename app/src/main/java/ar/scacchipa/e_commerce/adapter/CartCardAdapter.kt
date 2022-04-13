package ar.scacchipa.e_commerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.data.CartItem
import ar.scacchipa.e_commerce.databinding.LayoutCardviewCartItemBinding
import ar.scacchipa.e_commerce.viewmodel.ItemCartViewModel

class CartCardAdapter (
    private val itemList: List<CartItem>,
    private val itemCardVM: ItemCartViewModel
): RecyclerView.Adapter<CartCardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutCardviewCartItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutCardviewCartItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = itemList[position]
        card.item?.let { _item ->
            holder.binding.cartItemTitle.text = _item.title
            holder.binding.cartItemPrice.text = "$" + "%.${2}f".format(_item.price)
            holder.binding.cartItemImageView.setImageResource(_item.imageId)
            holder.binding.elementCount.text = card.itemCount.toString()
            holder.binding.ranking.text = "#${_item.ranking}"
            holder.binding.addOne.setOnClickListener { view ->
                itemCardVM.addCard(card.item, 1)
            }
            holder.binding.removeOne.setOnClickListener { view ->
                itemCardVM.addCard(card.item, - 1)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}