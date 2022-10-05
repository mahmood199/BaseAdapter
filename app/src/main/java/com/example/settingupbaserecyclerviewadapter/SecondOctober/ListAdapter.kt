package com.example.baservsetup.SecondOctober

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baservsetup.R
import com.example.baservsetup.databinding.TextBinding

class BasicRecyclerViewAdapter(
    private val _items: List<Any>,
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return TextViewHolder(
            TextBinding.inflate(
                LayoutInflater.from(parent.context)
            ))
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as BaseViewHolder<Any>).bind(_items[position])
    }

    override fun getItemCount() = _items.size


    override fun getItemViewType(position: Int): Int {
        return R.layout.text
    }
}