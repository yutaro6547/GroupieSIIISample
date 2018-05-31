package com.example.zukkey.groupiesiiisample

import android.view.View
import com.example.zukkey.groupiesiiisample.databinding.ItemHeaderBinding
import com.xwray.groupie.databinding.BindableItem


class HeaderItem(
        private val title: String,
        private val subTitle: String? = null
) : BindableItem<ItemHeaderBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_header
    }

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        viewBinding.title.text = title
        subTitle?.let { viewBinding.subTitle.text = it }
        if (subTitle == null) {
            viewBinding.subTitle.visibility = View.GONE
        }
    }

}