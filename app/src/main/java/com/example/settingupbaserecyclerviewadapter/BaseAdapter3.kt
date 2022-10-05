package com.example.settingupbaserecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter3<T : Any, VDB : ViewDataBinding>(
    private val list: ArrayList<T>,
    private val layoutId: Int,
    private inline val bind: (data: T, binding: VDB) -> Unit,
) : RecyclerView.Adapter<BaseAdapter3<T, VDB>.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return BaseViewHolder(binding, bind)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size


    inner class BaseViewHolder(
        private val binding: ViewDataBinding,
        private val bindVH: (data: T, binding: VDB) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bindData(any: T) {
            bindVH.invoke(any, binding as VDB)
        }


    }

}