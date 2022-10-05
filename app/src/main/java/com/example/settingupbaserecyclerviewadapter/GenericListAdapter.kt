package com.example.settingupbaserecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

abstract class GenericListAdapter<T : Any>(
    val layoutId: Int,
    inline val bind: (item: T, holder: BaseViewHolder, itemCount: Int) -> Unit,
) : ListAdapter<T, BaseViewHolder>(BaseItemCallBack<T>()) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(getItem(position), holder, itemCount)
    }

    override fun getItemViewType(position: Int) = layoutId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(
            viewType, parent, false
        )
        return BaseViewHolder(root as ViewGroup)
    }

    override fun getItemCount() = currentList.size
}