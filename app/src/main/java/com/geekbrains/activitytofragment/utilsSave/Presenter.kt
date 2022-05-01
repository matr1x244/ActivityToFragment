package com.geekbrains.activitytofragment.utilsSave

import com.geekbrains.activitytofragment.domain.TestEntityData

class Presenter(override val id: String) : BasePresenter {

    var currentTestEntity: TestEntityData? = null
}

