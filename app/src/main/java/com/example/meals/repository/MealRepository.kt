package com.example.meals.repository

import android.content.Context
import com.example.meals.api.MealService
import com.example.meals.db.MealDatabase
import com.example.meals.models.MealResponse
import com.example.meals.utils.NetworkUtils

class MealRepository(
    private val mealService: MealService,
    private val mealDatabase: MealDatabase,
    private val applicationContext: Context
){
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): List<MealResponse>?{
        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val response = mealService.getMeals()
            mealDatabase.mealDao().addMeals(response.categories)
            return mealDatabase.mealDao().getMeals()
        }
        else{
            return mealDatabase.mealDao().getMeals()
        }
    }

}