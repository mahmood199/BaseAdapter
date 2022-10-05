package com.example.baservsetup.SecondOctober

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T> internal constructor(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}