package com.example.meals.api

import com.example.meals.models.MealsCategoryResponse
import retrofit2.http.GET

interface MealService {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoryResponse
}