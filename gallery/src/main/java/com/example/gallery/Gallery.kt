package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.Toast
import android.widget.AdapterView


class Gallery : AppCompatActivity() {

    var images = arrayOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val galleryGridView: GridView = findViewById(R.id.gallery_grid_view)

        images.size
        // 1. 准备数据源
        val list = ArrayList<Map<String, Any>>()
        for (i in 0 until images.size) {
            val map = HashMap<String, Any>()
            map["image"] = images[i]
            map["text"] = "图片$i"
            list.add(map)
        }

        // 2.为数据源设置适配器
        val adapter = MyAdapter(list, applicationContext)
        // 3.将适配过后点数据显示在GridView 上
        galleryGridView.adapter = adapter
        // item点击事件处理
        galleryGridView.setOnItemClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            Toast.makeText(
                this,
                list[position]["text"].toString(),
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}
