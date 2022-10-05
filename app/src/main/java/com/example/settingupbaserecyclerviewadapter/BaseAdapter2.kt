package com.example.settingupbaserecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter2<T : Any, VDB : ViewDataBinding>(
    private val list: ArrayList<T>,
    private val layoutId: Int,
    private val bindingInterface: BindingInterface<T, VDB>,
) : ListAdapter<T, BaseAdapter2.BaseViewHolder>(BaseDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater,
            layoutId,
            parent,
            false
        )
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(list[position], bindingInterface)
        holder.setClickListener(list[position], bindingInterface)
    }


    class BaseViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun <T : Any, VDB : ViewDataBinding> setClickListener(
            item: T,
            bindingInterface: BindingInterface<T, VDB>,
        ) = bindingInterface.setClickListener(item, binding as VDB)


        fun <T : Any, VDB : ViewDataBinding> bind(
            item: T,
            bindingInterface: BindingInterface<T, VDB>,
        ) = bindingInterface.bindData(item, binding as VDB)

    }

}
