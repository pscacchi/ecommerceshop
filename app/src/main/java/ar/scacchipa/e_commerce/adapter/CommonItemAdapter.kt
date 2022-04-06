package ar.scacchipa.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.Fruit
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.databinding.LayoutCardviewGondolaItemCardBinding

class CommonItemAdapter(
    private val itemList: List<Fruit>
): RecyclerView.Adapter<CommonItemAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = LayoutCardviewGondolaItemCardBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_cardview_gondola_item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.commonItemTitle.text = item.title
        holder.binding.commonItemPrice.text = "$" + "%.${2}f".format(item.price)
        holder.binding.commonItemCategory.text = item.category
        holder.binding.commonItemImageView.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}