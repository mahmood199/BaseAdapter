package com.example.settingupbaserecyclerviewadapter.model

import com.example.settingupbaserecyclerviewadapter.base.BaseRecyclerViewItem

data class TextViewItem(
	val textId: Int,
	val text : String
) : BaseRecyclerViewItem<Int>() {

	override val id: Int
		get() = textId

}