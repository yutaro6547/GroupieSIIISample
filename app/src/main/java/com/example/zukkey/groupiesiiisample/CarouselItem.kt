package com.example.zukkey.groupiesiiisample

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.zukkey.groupiesiiisample.databinding.ItemCarouselBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.BindableItem


class CarouselItem(
        private val itemDecoration: RecyclerView.ItemDecoration,
        private val carouselAdapter: GroupAdapter<com.xwray.groupie.ViewHolder>
): BindableItem<ItemCarouselBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_carousel
    }

    override fun bind(viewBinding: ItemCarouselBinding, position: Int) {
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = carouselAdapter
            addItemDecoration(itemDecoration)
        }
    }
}
