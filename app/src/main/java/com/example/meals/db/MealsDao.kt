package com.example.meals.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.meals.models.MealResponse

@Dao
interface MealsDao {
    @Upsert
    suspend fun addMeals(meals: List<MealResponse>)

    @Query("SELECT * from meal_category_tbl")
    suspend fun getMeals(): List<MealResponse>

    @Query("SELECT * from meal_category_tbl where id=:id")
    suspend fun getMealById(id: String): MealResponse?
}