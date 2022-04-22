package com.geekbrains.activitytofragment.recyclerView

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.activitytofragment.domain.TestEntityData

class TestingAdapters : RecyclerView.Adapter<TestingViewHolder>() {

    var testListData: MutableList<TestEntityData> = mutableListOf()

//        @SuppressLint("NotifyDataSetChanged")
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<TestEntityData>) {
        testListData.clear()
        testListData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestingViewHolder {
        return TestingViewHolder.createView(parent)
    }

    override fun onBindViewHolder(holder: TestingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): TestEntityData {
        return testListData[position]
    }

    override fun getItemCount(): Int {
        return testListData.size
    }

}
