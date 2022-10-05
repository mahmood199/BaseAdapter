package com.example.settingupbaserecyclerviewadapter

import androidx.databinding.ViewDataBinding


interface BindingInterface<T : Any, VDB : ViewDataBinding> {
    fun bindData(model: T, binder: VDB)
    fun setClickListener(model: T, binder: VDB)
}