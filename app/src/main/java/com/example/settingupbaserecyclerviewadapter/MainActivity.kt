package com.example.baservsetup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baservsetup.SecondOctober.BaseListAdapter
import com.example.settingupbaserecyclerviewadapter.BindingInterface
import com.example.settingupbaserecyclerviewadapter.databinding.ActivityMainBinding
import com.example.settingupbaserecyclerviewadapter.databinding.TextBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)


		val bindingInterface = object : BindingInterface<String, TextBinding> {
			override fun bindData(model: String, binder: TextBinding) {
				binder.tvText.text = model
			}

			override fun setClickListener(model: String, binder: TextBinding) {
				binder.tvText.setOnClickListener {
					Toast.makeText(this@MainActivity, model, Toast.LENGTH_SHORT).show()
				}
			}

		}
		val list = ArrayList<String>()
		list.add("111")
		list.add("222")
		list.add("333")
		list.add("444")
		list.add("555")
		list.add("666")
		list.add("777")
		list.add("888")
		list.add("999")
		list.add("111")
		list.add("222")
		list.add("333")


		val adapter = BaseListAdapter<String>(
			{ li, parent, attach -> TextBinding.inflate(li, parent, attach) },
			{ item, vb -> (vb as TextBinding).tvText.text = item },
			{ item ->  displayToast(this, item) },
			{ old, new -> old == new },
			{ old, new -> old == new }
		)
		adapter.setItems(list)
		binding.rv1.adapter = adapter
	}

	private fun displayToast(mainActivity: MainActivity, s: String) {
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
	}
}

