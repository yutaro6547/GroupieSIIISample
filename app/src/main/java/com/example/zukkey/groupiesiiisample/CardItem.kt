package com.example.zukkey.groupiesiiisample

import android.content.Context
import android.support.annotation.ColorInt
import android.widget.Toast
import com.example.zukkey.groupiesiiisample.databinding.ItemCardBinding
import com.xwray.groupie.databinding.BindableItem


class CardItem(
        private val context: Context,
        @ColorInt private val color: Int,
        private val cardText:String,
        private val spanSizeCount: Int
): BindableItem<ItemCardBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_card
    }

    override fun bind(viewBinding: ItemCardBinding, position: Int) {
        viewBinding.itemCardTitle.text = cardText
        viewBinding.itemCard.setCardBackgroundColor(color)
        viewBinding.itemCardButton.setOnClickListener {
            // TODO: Button押したときになんか書く
            Toast.makeText(context, "Button Clicked Hahaha!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount / spanSizeCount
    }
}