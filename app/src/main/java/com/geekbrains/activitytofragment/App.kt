package com.geekbrains.activitytofragment

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.activitytofragment.data.MemoryTestRepositoryImpl
import com.geekbrains.activitytofragment.domain.TestRepository


class App : Application() {

    val testRepository: TestRepository by lazy { MemoryTestRepositoryImpl() } // обязательно by lazy
}

/**
 * Чтобы использовать пример:
 * в FirstFragment функцию
 * private fun recyclerView(){
 * binding.recyclerView.apply {
 * layoutManager = LinearLayoutManager(requireContext())
 * adapter = testingAdapters } // конектим адаптер
 *
 * Далее вытаскиваем данные из App!!
 * Чтобы не делать вот так: (requireContext().applicationContext as App).testRepository.getText()
 * --------------
 * А делать вот так: testingAdapters.testListData = testRepository.getText().toMutableList() // подцепляем данные
 * Тогда нужно использовать val Fragment.app: App или val Context.app: App
 */

// Для получения App
val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app

