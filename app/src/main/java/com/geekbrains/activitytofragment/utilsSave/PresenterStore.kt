package com.geekbrains.activitytofragment.utilsSave

import java.util.*

class PresenterStore {
    private val storage: MutableMap<String, BasePresenter> = WeakHashMap()

    fun savePresenter(presenter: BasePresenter) {
        storage[presenter.id] = presenter // сохраняем ID presenter
    }

    fun getPresenter(id: String): BasePresenter? {
        return storage[id] // возвращаем ID
    }
}

interface BasePresenter {
    val id: String
}

