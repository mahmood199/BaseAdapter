package com.example.baservsetup.SecondOctober

import com.example.baservsetup.databinding.TextBinding

class TextViewHolder(private val binding : TextBinding) : BaseViewHolder<String>(binding.root) {

    override fun bind(item: String) {
        binding.apply {
            tvText.text = item
        }
    }

}