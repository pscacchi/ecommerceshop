package ar.scacchipa.e_commerce.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import ar.scacchipa.e_commerce.databinding.CartIconLayoutBinding

class IndicatorActionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private var binding: CartIconLayoutBinding =
        CartIconLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    fun setNum(num: Int) {
        binding.counterNumberText.text = num.toString()
        if (num == 0) {
            hideCounter()
        } else {
            showCounter()
        }
    }

    private fun hideCounter() {
        binding.counterNumberText.visibility = View.INVISIBLE
        binding.bubbleCounterView.visibility = View.INVISIBLE
    }

    private fun showCounter() {
        binding.counterNumberText.visibility = View.VISIBLE
        binding.bubbleCounterView.visibility = View.VISIBLE
    }
}