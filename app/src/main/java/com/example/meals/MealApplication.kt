package com.example.meals

import android.app.Application
import com.example.meals.api.MealService
import com.example.meals.api.RetrofitHelper
import com.example.meals.db.MealDatabase
import com.example.meals.repository.MealRepository

class MealApplication : Application() {
    lateinit var mealRepository: MealRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }
    private fun initialize(){
        val mealService = RetrofitHelper.getInstance().create(MealService::class.java)
        val database = MealDatabase.getDatabase(applicationContext)
        mealRepository = MealRepository(mealService, database, applicationContext)
    }
}