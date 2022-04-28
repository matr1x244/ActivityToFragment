package com.geekbrains.activitytofragment.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.activitytofragment.R
import com.geekbrains.activitytofragment.app
import com.geekbrains.activitytofragment.databinding.FragmentFirstBinding
import com.geekbrains.activitytofragment.domain.TestEntityData
import com.geekbrains.activitytofragment.domain.TestRepository
import com.geekbrains.activitytofragment.recyclerView.TestingAdapters

/**
 * Не забудь отнаследовать активити от контроллера
 */
class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    /*задаем адаптер*/
    private var testingAdapters = TestingAdapters {
        controller.openSecondFragment(it) // подключли контроллер к адаптеру на кликабельность
        Toast.makeText(context, it.textView, Toast.LENGTH_SHORT).show()
    }

    private val testRepository: TestRepository by lazy { app.testRepository } // получаем из App обязательно "by lazy" только по запросу

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*Проверяем есть ли у активити Controller*/
        if (activity !is Controller) {
            throw IllegalStateException("Activity должна наследоваться от FirstFragment.Controller")
        }
    }

    private val controller by lazy { activity as Controller } // проверяем по запросу controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRetainInstance(true) // простое решение сохранение состояние фрагмента, но работает не всегда

        buttonFirst()
        recyclerView()
        buttonReload()
    }

    private fun buttonReload() {
        binding.buttonReload.setOnClickListener {
            activity?.supportFragmentManager?.let { fragment ->
                fragment.beginTransaction()
                    .replace(R.id.container_main_activity, FirstFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
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
                .replace(R.id.container_main_activity, SecondFragment.newInstance(testEntityData = null))
                .addToBackStack(null)
                .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*Интерфейс контроля для кликабельности с MainActivity*/
    interface Controller {
        fun openSecondFragment(testData: TestEntityData)
    }
}