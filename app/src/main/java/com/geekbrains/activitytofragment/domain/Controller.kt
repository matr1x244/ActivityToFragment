package com.geekbrains.activitytofragment.domain

/*Интерфейс контроля для кликабельности с MainActivity*/
interface Controller {
    fun openSecondFragment(testData: TestEntityData)
}