package ar.scacchipa.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.Fruit
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.databinding.LayoutCardviewHighlightItemBinding

class HighlightedItemAdapter(
    val itemList: List<Fruit>
): RecyclerView.Adapter<HighlightedItemAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = LayoutCardviewHighlightItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_cardview_highlight_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.highItemTitle.text = item.title
        holder.binding.highItemPrice.text = "$" + "%.${2}f".format(item.price)
        holder.binding.highItemImageView.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}