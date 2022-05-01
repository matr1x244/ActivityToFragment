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
import com.geekbrains.activitytofragment.data.MemoryTestRepositoryImpl
import com.geekbrains.activitytofragment.databinding.FragmentFirstBinding
import com.geekbrains.activitytofragment.domain.Controller
import com.geekbrains.activitytofragment.domain.TestRepository
import com.geekbrains.activitytofragment.recyclerView.TestingAdapters
import com.geekbrains.activitytofragment.utilsSave.Presenter
import java.util.*

/**
 * Не забудь отнаследовать активити от контроллера
 */
class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: Presenter

    /*задаем адаптер*/
    private var testingAdapters = TestingAdapters {
        controller.openSecondFragment(it) // подключли контроллер к адаптеру на кликабельность

        presenter.currentTestEntity = it
        it.textId

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

        if (savedInstanceState != null) {
            val presenterId = savedInstanceState.getString("presenter_id") // если есть presenter id
            presenter = presenterId?.let { app.presenterStore.getPresenter(it) } as Presenter // тогда достаем id presenter из getPresenter
        } else {
            val id = UUID.randomUUID().toString() //генерируем random ID
            presenter = Presenter(id) // задаем random Id
            app.presenterStore.savePresenter(presenter) // сохраняем в presenter id
        }

        presenter.currentTestEntity?.let {
            it.textId
        }


        buttonFirst()
        recyclerView()
        buttonReload()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("presenter_id", presenter.id) //сохраняем id presenter
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

}