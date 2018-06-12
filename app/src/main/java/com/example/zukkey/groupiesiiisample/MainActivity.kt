package com.example.zukkey.groupiesiiisample

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.zukkey.groupiesiiisample.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 2
        }

        val cardItem = generateCards(6, 2)

        Section(HeaderItem("HI Guys!!")).apply {
            add(ColumnGroup(cardItem))
            groupAdapter.add(this)
        }

//        Section(HeaderItem("Fucking Guys!!")).apply {
//            add(makeCarouselItem())
//        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }
    }

    private fun generateCards(count: Int, spanSizeCount: Int): MutableList<CardItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(255, rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256))
            CardItem(this, color, "test", spanSizeCount)
        }
    }

//    private fun makeCarouselItem(): CarouselItem {
//        val carouselDecoration = CarouselItemDecoration(gray, betweenPadding)
//        val carouselAdapter = GroupAdapter<ViewHolder>()
//        for (i in 0..29) {
//            carouselAdapter.add(generateCards(i, 4))
//        }
//        return CarouselItem(carouselDecoration, carouselAdapter)
//    }
}
