package com.geekbrains.activitytofragment.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.activitytofragment.R
import com.geekbrains.activitytofragment.databinding.RecyclerItemBinding
import com.geekbrains.activitytofragment.domain.TestEntityData

class TestingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = RecyclerItemBinding.bind(itemView) // подцепляем макет к binding

    companion object {
        fun createView(parent: ViewGroup): TestingViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return TestingViewHolder(view)
        }
    }

    fun bind(item: TestEntityData, listener: TestEntityData.() -> Unit) {
        binding.itemTextNull.text = item.textId
        binding.itemTextOne.text = item.textNumber.toString()
        binding.itemTextTwo.text = item.textView
        binding.root.setOnClickListener {
            listener.invoke(item) /*listener слушать события*/
        }
    }

}