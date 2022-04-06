package ar.scacchipa.e_commerce

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView

class SquareCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (widthMeasureSpec < heightMeasureSpec) super.onMeasure(
            widthMeasureSpec,
            widthMeasureSpec
        ) else super.onMeasure(heightMeasureSpec, heightMeasureSpec)
    }
}