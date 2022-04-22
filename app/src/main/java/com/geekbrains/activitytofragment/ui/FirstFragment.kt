package com.geekbrains.activitytofragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.activitytofragment.R
import com.geekbrains.activitytofragment.app
import com.geekbrains.activitytofragment.databinding.FragmentFirstBinding
import com.geekbrains.activitytofragment.domain.TestRepository
import com.geekbrains.activitytofragment.recyclerView.TestingAdapters

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val testingAdapters = TestingAdapters() // задаем адаптер
    private val testRepository: TestRepository by lazy { app.testRepository } // получаем из App обязательно "by lazy" только по запросу

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonFirst()
        recyclerView()
    }

    private fun recyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = testingAdapters // конектим адаптер
        }
        testingAdapters.setData(testRepository.getTextFun()) // подцепляем данные, если работаем через fun setData в TestingAdapters
//      testingAdapters.testListData = testRepository.getTextFun().toMutableList() // подцепляем данные, если использовать в TestingAdapters set(value) {field = value  notifyDataSetChanged()}
    }

    private fun buttonFirst() {
        binding.buttonFirst.setOnClickListener {
            activity?.supportFragmentManager?.let { fragment ->
                fragment.beginTransaction()
                    .replace(R.id.container_main_activity, SecondFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}