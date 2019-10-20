package com.example.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MyAdapter(arr: List<Map<String, Any>>, applicationContext: Context) : BaseAdapter() {
    private var list: List<Map<String, Any>> = arr
    private var context: Context = applicationContext

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val inflate: View

        if (convertView == null) {
            // 第一次加载创建View，其余复用 View
            inflate = LayoutInflater.from(context).inflate(R.layout.grad_view_item, null)

            viewHolder = ViewHolder()
            viewHolder.imageView = inflate.findViewById(R.id.grid_img)
            viewHolder.textView = inflate.findViewById(R.id.grid_desc)
            inflate.tag = viewHolder

        } else {
            inflate = convertView
            viewHolder = inflate.tag as ViewHolder
        }
        viewHolder.imageView!!.setImageResource((list[position]["image"] as Int))
        viewHolder.textView!!.text = (list[position]["text"] as String)

        return inflate

    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}