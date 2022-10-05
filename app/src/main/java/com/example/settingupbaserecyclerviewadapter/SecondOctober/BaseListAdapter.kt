package com.example.baservsetup.SecondOctober

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseListAdapter<T>(
    private val inflate: (layoutInflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean) -> ViewBinding,
    private val bind: (item: T, binding: ViewBinding) -> Unit,
    private val onClick: (item: T) -> Unit,
    compareItems: (old: T, new: T) -> Boolean,
    compareContents: (old: T, new: T) -> Boolean
) : ListAdapter<T, RecyclerView.ViewHolder>(DiffCallback(compareItems, compareContents)) {


    var items = emptyList<T>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind(getItem(position), (holder as BaseListAdapter<T>.ItemViewHolder).binding)
    }

    internal fun setItems(items: List<T>) {
        this.items = items
        this.submitList(items)
    }

    inner class ItemViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder((binding).root) {
        init {
            binding.root.setOnClickListener { onClick(getItem(adapterPosition)) }
        }
    }

    private class DiffCallback<K>(
        private val compareItems: (old: K, new: K) -> Boolean,
        private val compareContents: (old: K, new: K) -> Boolean
    ) : DiffUtil.ItemCallback<K>() {
        override fun areItemsTheSame(old: K, new: K) = compareItems(old, new)
        override fun areContentsTheSame(old: K, new: K) = compareContents(old, new)
    }
}


/*
Usage
val adapter = BaseListAdapter<Customer>(
    { li, parent, attach -> RvCustomerBinding.inflate(li, parent, attach) },
    { item, vb -> (vb as RvCustomerBinding).tvName.text = item.name },
    { item -> displayToast(requireContext(), "Customer: ${item.name}") },
    { old, new -> old.id == new.id },
    { old, new -> old == new }
)*/
