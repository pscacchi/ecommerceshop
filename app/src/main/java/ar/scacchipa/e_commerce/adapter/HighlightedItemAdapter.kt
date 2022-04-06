package ar.scacchipa.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ar.scacchipa.e_commerce.Fruit
import ar.scacchipa.e_commerce.R
import ar.scacchipa.e_commerce.app.GondolaFragmentDirections
import ar.scacchipa.e_commerce.databinding.LayoutCardviewHighlightItemBinding

class HighlightedItemAdapter(
    private val itemList: List<Fruit>
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

        holder.binding.highlightedItemTitle.text = item.title
        holder.binding.highlightedItemPrice.text = "$" + "%.${2}f".format(item.price)
        holder.binding.highItemImageView.setImageResource(item.imageId)
        holder.binding.highItemConstrint.setOnClickListener { v ->
            val action: NavDirections = GondolaFragmentDirections
                .actionGondolaFragmentToDetailFragment(item)
            v.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}