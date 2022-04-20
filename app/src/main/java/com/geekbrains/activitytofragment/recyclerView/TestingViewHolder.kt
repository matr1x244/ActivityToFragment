package com.geekbrains.activitytofragment.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.activitytofragment.R
import com.geekbrains.activitytofragment.domain.TestEntityData
import com.geekbrains.activitytofragment.databinding.RecyclerItemBinding

class TestingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = RecyclerItemBinding.bind(itemView) // подцепляем макет к binding

    companion object {
        fun createView(parent: ViewGroup): TestingViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return TestingViewHolder(view)
        }
    }

    fun bind(item: TestEntityData) {
        binding.itemTextNull.text = item.textId
        binding.itemTextOne.text = item.textNumber.toString()
        binding.itemTextTwo.text = item.textView
    }

}